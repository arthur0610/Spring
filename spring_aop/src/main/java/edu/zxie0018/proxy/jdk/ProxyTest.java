package edu.zxie0018.proxy.jdk;

import edu.zxie0018.aop.Target;
import edu.zxie0018.aop.TargetInterface;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {

        final Target target = new Target();

        final ProTarget proTarget = new ProTarget();

        TargetInterface proxyTarget = (TargetInterface) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object ret = null;

                        proTarget.beforePro();
                        ret = method.invoke(target, args);
                        proTarget.afterPro();

                        return ret;
                    }
                }
        );

        proxyTarget.save();
    }
}
