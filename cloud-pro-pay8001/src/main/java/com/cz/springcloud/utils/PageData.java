package com.cz.springcloud.utils;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.*;

public class PageData extends HashMap implements Map, Serializable {
    private static final long serialVersionUID = 1L;
    Map map;
    HttpServletRequest request;

    public PageData(HttpServletRequest request) {
        this.request = request;
        Map properties = request.getParameterMap();
        Map returnMap = new HashMap();
        Iterator entries = properties.entrySet().iterator();

        String name = "";
        String value = "";
        while (entries.hasNext()) {
            Entry entry = (Entry) entries.next();
            name = (String) entry.getKey();
            Object valueObj = entry.getValue();
            if (valueObj == null) {
                value = "";
            } else if ((valueObj instanceof String[])) {
                String[] values = (String[]) valueObj;
                for (int i = 0; i < values.length; i++) {
                    value = values[i] + ",";
                }
                value = value.substring(0, value.length() - 1);
            } else {
                value = valueObj.toString();
            }
            returnMap.put(name, value);
        }
        this.map = returnMap;
    }

    public PageData() {
        this.map = new HashMap();
    }

    @Override
    public Object get(Object key) {
        Object obj;
        if ((this.map.get(key) instanceof Object[])) {
            Object[] arr = (Object[]) this.map.get(key);
            obj = this.request.getParameter((String) key) == null ? arr : this.request == null ? arr : arr[0];
        } else {
            obj = this.map.get(key);
        }
        return obj;
    }

    public String getString(Object key) {
        if (null == get(key)){
            return "";
        }
        return get(key).toString();
    }


    public Integer getInteger(Object key) {
        if (null == get(key)){
            return null;
        }
        return Integer.valueOf(get(key).toString());
    }


    @Override
    public Object put(Object key, Object value) {
        if (value != null) {
            if ((value instanceof Timestamp)) {
                value = DateUtil.getTime(Timestamp.valueOf(value.toString()));
            } else if ((value instanceof Date)) {
                value = DateUtil.getTime((Date) value);
            }
        }

        return this.map.put(key, value);
    }

    @Override
    public Object remove(Object key) {
        return this.map.remove(key);
    }

    @Override
    public void clear() {
        this.map.clear();
    }

    @Override
    public boolean containsKey(Object key) {
        return this.map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return this.map.containsValue(value);
    }

    @Override
    public Set entrySet() {
        return this.map.entrySet();
    }

    @Override
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override
    public Set keySet() {
        return this.map.keySet();
    }

    @Override
    public void putAll(Map t) {
        this.map.putAll(t);
    }

    @Override
    public int size() {
        return this.map.size();
    }

    @Override
    public Collection values() {
        return this.map.values();
    }
}
