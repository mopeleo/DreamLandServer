package com.dl.base.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dl.base.exception.DLUtilException;

import net.sf.cglib.beans.BeanCopier;

public class BeanPropertyCopy {

    private static final Map<String, BeanCopier> BEANCOPIER_CACHE = new HashMap<String, BeanCopier>();
    
    private BeanPropertyCopy(){}
    
    private static <S, T> BeanCopier getBeanCopier(Class<S> source, Class<T> target){
        String key = source.getName() + target.getName();
        BeanCopier copier = BEANCOPIER_CACHE.get(key);
        if(copier == null){
            copier = BeanCopier.create(source, target, false);
            BEANCOPIER_CACHE.put(key, copier);
        }
        return copier;
    }
    
    public static <S, T> void copy(final S source, final T target) {
        if(source == null || target == null){
            throw new DLUtilException("参数错误：参数为空");
        }
        BeanCopier copier = getBeanCopier(source.getClass(), target.getClass());
        copier.copy(source, target, null);
    }
    
    public static <S, T> T convert(S source, Class<T> target) {
        BeanCopier copier = getBeanCopier(source.getClass(), target);
        try {
            T obj = target.newInstance();
            copier.copy(source, obj, null);
            return obj;
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static <S, T> List<T> convertList(List<S> sourceList, Class<T> target) {
        List<T> result = new ArrayList<T>();
        if(sourceList == null || sourceList.size() == 0){
            return result;
        }
        
        for(S source : sourceList){
            T t = convert(source, target);
            result.add(t);
        }
        return result;
    }
}
