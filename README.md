# SpringBootRedisSession
Spring Boot + Redis 实现Session共享
## 共享Session问题

​      HttpSession是通过Servlet容器创建和管理的，像Tomcat/Jetty都是保存在内存中的。而如果我们把web服务器搭建成分布式的集群，然后利用LVS或Nginx做负载均衡，那么来自同一用户的Http请求将有可能被分发到两个不同的web站点中去。那么问题就来了，如何保证不同的web站点能够共享同一份session数据呢？ 

​     分布式系统中，Session 共享有很多的解决方案，其中托管到缓存中应该是最常用的方案之一 

## 
