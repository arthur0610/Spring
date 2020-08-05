package edu.zxie0018.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyTest {
    public static void main(String[] args) {

        final Target target = new Target();

        final ProTarget proTarget = new ProTarget();

        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(Target.class);

        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                Object invoke = null;

                proTarget.beforePro();

                invoke = method.invoke(target, args);

                proTarget.afterPro();

                return invoke;
            }
        });

        Target proxyTarget = (Target) enhancer.create();

        proxyTarget.save();
    }
}
