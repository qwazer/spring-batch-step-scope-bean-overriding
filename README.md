This is demonstration of conflicting when

1. use `step` or `job` scoped beans in Spring Batch configuration
2. use Spring Boot 2.x with default properties


`contextLoads` test produce output:


```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.1.6.RELEASE)

2019-07-03 17:48:03.012  INFO 17027 --- [    Test worker] hStepScopeBeanOverridingApplicationTests : Starting SpringBatchStepScopeBeanOverridingApplicationTests on areshetnikov-pc with PID 17027 (started by ar in /home/ar/projects/github/spring-batch-step-scope-bean-overriding)
2019-07-03 17:48:03.013  INFO 17027 --- [    Test worker] hStepScopeBeanOverridingApplicationTests : No active profile set, falling back to default profiles: default
2019-07-03 17:48:03.096  WARN 17027 --- [    Test worker] s.c.a.AnnotationConfigApplicationContext : Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.support.BeanDefinitionOverrideException: Invalid bean definition with name 'dummyReader' defined in BeanDefinition defined in class path resource [job.xml]: Cannot register bean definition [Root bean: class [org.springframework.aop.scope.ScopedProxyFactoryBean]; scope=; abstract=false; lazyInit=false; autowireMode=0; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=null; factoryMethodName=null; initMethodName=null; destroyMethodName=null; defined in BeanDefinition defined in class path resource [job.xml]] for bean 'dummyReader': There is already [Generic bean: class [com.github.qwazer.sbssbo.DummyReader]; scope=step; abstract=false; lazyInit=false; autowireMode=0; dependencyCheck=0; autowireCandidate=false; primary=false; factoryBeanName=null; factoryMethodName=null; initMethodName=null; destroyMethodName=null; defined in class path resource [job.xml]] bound.
2019-07-03 17:48:03.098  INFO 17027 --- [    Test worker] ConditionEvaluationReportLoggingListener :

Error starting ApplicationContext. To display the conditions report re-run your application with 'debug' enabled.
2019-07-03 17:48:03.098 ERROR 17027 --- [    Test worker] o.s.b.d.LoggingFailureAnalysisReporter   :

***************************
APPLICATION FAILED TO START
***************************

Description:

The bean 'dummyReader', defined in BeanDefinition defined in class path resource [job.xml], could not be registered. A bean with that name has already been defined in class path resource [job.xml] and overriding is disabled.

Action:

Consider renaming one of the beans or enabling overriding by setting spring.main.allow-bean-definition-overriding=true

2019-07-03 17:48:03.102 ERROR 17027 --- [    Test worker] o.s.test.context.TestContextManager      : Caught exception while allowing TestExecutionListener [org.springframework.boot.test.autoconfigure.SpringBootDependencyInjectionTestExecutionListener@36f2a582] to prepare test instance [com.github.qwazer.sbssbo.SpringBatchStepScopeBeanOverridingApplicationTests@19fda059]

java.lang.IllegalStateException: Failed to load ApplicationContext
	at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:125) ~[spring-test-5.1.8.RELEASE.jar:5.1.8.RELEASE]
	at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:108) ~[spring-test-5.1.8.RELEASE.jar:5.1.8.RELEASE]
	at org.springframework.test.context.support.DependencyInjectionTestExecutionListener.injectDependencies(DependencyInjectionTestExecutionListener.java:118) ~[spring-test-5.1.8.RELEASE.jar:5.1.8.RELEASE]
	at org.springframework.test.context.support.DependencyInjectionTestExecutionListener.prepareTestInstance(DependencyInjectionTestExecutionListener.java:83) ~[spring-test-5.1.8.RELEASE.jar:5.1.8.RELEASE]
	at org.springframework.boot.test.autoconfigure.SpringBootDependencyInjectionTestExecutionListener.prepareTestInstance(SpringBootDependencyInjectionTestExecutionListener.java:43) ~[spring-boot-test-autoconfigure-2.1.6.RELEASE.jar:2.1.6.RELEASE]
	at org.springframework.test.context.TestContextManager.prepareTestInstance(TestContextManager.java:246) ~[spring-test-5.1.8.RELEASE.jar:5.1.8.RELEASE]
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.createTest(SpringJUnit4ClassRunner.java:227) [spring-test-5.1.8.RELEASE.jar:5.1.8.RELEASE]
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner$1.runReflectiveCall(SpringJUnit4ClassRunner.java:289) [spring-test-5.1.8.RELEASE.jar:5.1.8.RELEASE]
	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12) [junit-4.12.jar:4.12]
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.methodBlock(SpringJUnit4ClassRunner.java:291) [spring-test-5.1.8.RELEASE.jar:5.1.8.RELEASE]
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.runChild(SpringJUnit4ClassRunner.java:246) [spring-test-5.1.8.RELEASE.jar:5.1.8.RELEASE]
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.runChild(SpringJUnit4ClassRunner.java:97) [spring-test-5.1.8.RELEASE.jar:5.1.8.RELEASE]
	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290) [junit-4.12.jar:4.12]
	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71) [junit-4.12.jar:4.12]
	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288) [junit-4.12.jar:4.12]
	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58) [junit-4.12.jar:4.12]
	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268) [junit-4.12.jar:4.12]
	at org.springframework.test.context.junit4.statements.RunBeforeTestClassCallbacks.evaluate(RunBeforeTestClassCallbacks.java:61) [spring-test-5.1.8.RELEASE.jar:5.1.8.RELEASE]
	at org.springframework.test.context.junit4.statements.RunAfterTestClassCallbacks.evaluate(RunAfterTestClassCallbacks.java:70) [spring-test-5.1.8.RELEASE.jar:5.1.8.RELEASE]
	at org.junit.runners.ParentRunner.run(ParentRunner.java:363) [junit-4.12.jar:4.12]
	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.run(SpringJUnit4ClassRunner.java:190) [spring-test-5.1.8.RELEASE.jar:5.1.8.RELEASE]
	at org.gradle.api.internal.tasks.testing.junit.JUnitTestClassExecutor.runTestClass(JUnitTestClassExecutor.java:110) [gradle-testing-jvm-5.4.1.jar:5.4.1]
	at org.gradle.api.internal.tasks.testing.junit.JUnitTestClassExecutor.execute(JUnitTestClassExecutor.java:58) [gradle-testing-jvm-5.4.1.jar:5.4.1]
	at org.gradle.api.internal.tasks.testing.junit.JUnitTestClassExecutor.execute(JUnitTestClassExecutor.java:38) [gradle-testing-jvm-5.4.1.jar:5.4.1]
	at org.gradle.api.internal.tasks.testing.junit.AbstractJUnitTestClassProcessor.processTestClass(AbstractJUnitTestClassProcessor.java:62) [gradle-testing-jvm-5.4.1.jar:5.4.1]
	at org.gradle.api.internal.tasks.testing.SuiteTestClassProcessor.processTestClass(SuiteTestClassProcessor.java:51) [gradle-testing-base-5.4.1.jar:5.4.1]
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:1.8.0_201]
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[na:1.8.0_201]
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:1.8.0_201]
	at java.lang.reflect.Method.invoke(Method.java:498) ~[na:1.8.0_201]
	at org.gradle.internal.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:35) [gradle-messaging-5.4.1.jar:5.4.1]
	at org.gradle.internal.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:24) [gradle-messaging-5.4.1.jar:5.4.1]
	at org.gradle.internal.dispatch.ContextClassLoaderDispatch.dispatch(ContextClassLoaderDispatch.java:32) [gradle-messaging-5.4.1.jar:5.4.1]
	at org.gradle.internal.dispatch.ProxyDispatchAdapter$DispatchingInvocationHandler.invoke(ProxyDispatchAdapter.java:93) [gradle-messaging-5.4.1.jar:5.4.1]
	at com.sun.proxy.$Proxy2.processTestClass(Unknown Source) [na:na]
	at org.gradle.api.internal.tasks.testing.worker.TestWorker.processTestClass(TestWorker.java:118) [gradle-testing-base-5.4.1.jar:5.4.1]
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:1.8.0_201]
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[na:1.8.0_201]
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:1.8.0_201]
	at java.lang.reflect.Method.invoke(Method.java:498) ~[na:1.8.0_201]
	at org.gradle.internal.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:35) [gradle-messaging-5.4.1.jar:5.4.1]
	at org.gradle.internal.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:24) [gradle-messaging-5.4.1.jar:5.4.1]
	at org.gradle.internal.remote.internal.hub.MessageHubBackedObjectConnection$DispatchWrapper.dispatch(MessageHubBackedObjectConnection.java:175) [gradle-messaging-5.4.1.jar:5.4.1]
	at org.gradle.internal.remote.internal.hub.MessageHubBackedObjectConnection$DispatchWrapper.dispatch(MessageHubBackedObjectConnection.java:157) [gradle-messaging-5.4.1.jar:5.4.1]
	at org.gradle.internal.remote.internal.hub.MessageHub$Handler.run(MessageHub.java:404) [gradle-messaging-5.4.1.jar:5.4.1]
	at org.gradle.internal.concurrent.ExecutorPolicy$CatchAndRecordFailures.onExecute(ExecutorPolicy.java:63) [gradle-base-services-5.4.1.jar:5.4.1]
	at org.gradle.internal.concurrent.ManagedExecutorImpl$1.run(ManagedExecutorImpl.java:46) [gradle-base-services-5.4.1.jar:5.4.1]
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149) [na:1.8.0_201]
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624) [na:1.8.0_201]
	at org.gradle.internal.concurrent.ThreadFactoryImpl$ManagedThreadRunnable.run(ThreadFactoryImpl.java:55) [gradle-base-services-5.4.1.jar:5.4.1]
	at java.lang.Thread.run(Thread.java:748) [na:1.8.0_201]
Caused by: org.springframework.beans.factory.support.BeanDefinitionOverrideException: Invalid bean definition with name 'dummyReader' defined in BeanDefinition defined in class path resource [job.xml]: Cannot register bean definition [Root bean: class [org.springframework.aop.scope.ScopedProxyFactoryBean]; scope=; abstract=false; lazyInit=false; autowireMode=0; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=null; factoryMethodName=null; initMethodName=null; destroyMethodName=null; defined in BeanDefinition defined in class path resource [job.xml]] for bean 'dummyReader': There is already [Generic bean: class [com.github.qwazer.sbssbo.DummyReader]; scope=step; abstract=false; lazyInit=false; autowireMode=0; dependencyCheck=0; autowireCandidate=false; primary=false; factoryBeanName=null; factoryMethodName=null; initMethodName=null; destroyMethodName=null; defined in class path resource [job.xml]] bound.
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.registerBeanDefinition(DefaultListableBeanFactory.java:893) ~[spring-beans-5.1.8.RELEASE.jar:5.1.8.RELEASE]
	at org.springframework.batch.core.scope.BatchScopeSupport.createScopedProxy(BatchScopeSupport.java:159) ~[spring-batch-core-4.1.2.RELEASE.jar:4.1.2.RELEASE]
	at org.springframework.batch.core.scope.BatchScopeSupport.postProcessBeanFactory(BatchScopeSupport.java:130) ~[spring-batch-core-4.1.2.RELEASE.jar:4.1.2.RELEASE]
	at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(PostProcessorRegistrationDelegate.java:286) ~[spring-context-5.1.8.RELEASE.jar:5.1.8.RELEASE]
	at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(PostProcessorRegistrationDelegate.java:174) ~[spring-context-5.1.8.RELEASE.jar:5.1.8.RELEASE]
	at org.springframework.context.support.AbstractApplicationContext.invokeBeanFactoryPostProcessors(AbstractApplicationContext.java:705) ~[spring-context-5.1.8.RELEASE.jar:5.1.8.RELEASE]
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:531) ~[spring-context-5.1.8.RELEASE.jar:5.1.8.RELEASE]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:742) ~[spring-boot-2.1.6.RELEASE.jar:2.1.6.RELEASE]
	at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:389) ~[spring-boot-2.1.6.RELEASE.jar:2.1.6.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:311) ~[spring-boot-2.1.6.RELEASE.jar:2.1.6.RELEASE]
	at org.springframework.boot.test.context.SpringBootContextLoader.loadContext(SpringBootContextLoader.java:119) ~[spring-boot-test-2.1.6.RELEASE.jar:2.1.6.RELEASE]
	at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99) ~[spring-test-5.1.8.RELEASE.jar:5.1.8.RELEASE]
	at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:117) ~[spring-test-5.1.8.RELEASE.jar:5.1.8.RELEASE]
	... 50 common frames omitted
```