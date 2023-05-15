/* Generated by camel build tools - do NOT edit this file! */
package org.apache.camel.component.mybatis;

import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.spi.ExtendedPropertyConfigurerGetter;
import org.apache.camel.spi.PropertyConfigurerGetter;
import org.apache.camel.spi.ConfigurerStrategy;
import org.apache.camel.spi.GeneratedPropertyConfigurer;
import org.apache.camel.util.CaseInsensitiveMap;
import org.apache.camel.support.component.PropertyConfigurerSupport;

/**
 * Generated by camel build tools - do NOT edit this file!
 */
@SuppressWarnings("unchecked")
public class MyBatisBeanComponentConfigurer extends PropertyConfigurerSupport implements GeneratedPropertyConfigurer, PropertyConfigurerGetter {

    @Override
    public boolean configure(CamelContext camelContext, Object obj, String name, Object value, boolean ignoreCase) {
        MyBatisBeanComponent target = (MyBatisBeanComponent) obj;
        switch (ignoreCase ? name.toLowerCase() : name) {
        case "autowiredenabled":
        case "autowiredEnabled": target.setAutowiredEnabled(property(camelContext, boolean.class, value)); return true;
        case "configurationuri":
        case "configurationUri": target.setConfigurationUri(property(camelContext, java.lang.String.class, value)); return true;
        case "lazystartproducer":
        case "lazyStartProducer": target.setLazyStartProducer(property(camelContext, boolean.class, value)); return true;
        case "sqlsessionfactory":
        case "sqlSessionFactory": target.setSqlSessionFactory(property(camelContext, org.apache.ibatis.session.SqlSessionFactory.class, value)); return true;
        default: return false;
        }
    }

    @Override
    public String[] getAutowiredNames() {
        return new String[]{"sqlSessionFactory"};
    }

    @Override
    public Class<?> getOptionType(String name, boolean ignoreCase) {
        switch (ignoreCase ? name.toLowerCase() : name) {
        case "autowiredenabled":
        case "autowiredEnabled": return boolean.class;
        case "configurationuri":
        case "configurationUri": return java.lang.String.class;
        case "lazystartproducer":
        case "lazyStartProducer": return boolean.class;
        case "sqlsessionfactory":
        case "sqlSessionFactory": return org.apache.ibatis.session.SqlSessionFactory.class;
        default: return null;
        }
    }

    @Override
    public Object getOptionValue(Object obj, String name, boolean ignoreCase) {
        MyBatisBeanComponent target = (MyBatisBeanComponent) obj;
        switch (ignoreCase ? name.toLowerCase() : name) {
        case "autowiredenabled":
        case "autowiredEnabled": return target.isAutowiredEnabled();
        case "configurationuri":
        case "configurationUri": return target.getConfigurationUri();
        case "lazystartproducer":
        case "lazyStartProducer": return target.isLazyStartProducer();
        case "sqlsessionfactory":
        case "sqlSessionFactory": return target.getSqlSessionFactory();
        default: return null;
        }
    }
}

