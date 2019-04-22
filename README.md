# Software Structured Design And Architecture Assignment 3

## 佈署文#檔

### 項目主頁

'path'/index

##**在Tomcat中部署war:**
1. 将war文件拷贝到tomcat目录webapps下（不要再建目录）。

2. 将必要的jar文件拷贝到tomcat目录libxia下。 maven打包时已经将需要的jar打到class目录下，不再需要单独导包。

3. 修改tomcat目录conf下的server.xml。
在<Host></Host>中加入：

```
<Context path="/manager" docBase="manager" debug=“0" privileged="true"/>
```

4. path=“" 为部署后运行的url路径，可直接设定path为“”，则根目录直接打开；

5. docBase为你的war的文件名。 第一次运行的时候，tomcat会自动解压war，生成path指定名称的网站。这里docBase中的”manager”就表示war文件名称为“manager.war”;

6. reloadable:如果设置为"true",则表示当你修改jsp文件后,不需要重启服务器就可以实现页面显示的同步.

7. 完毕，通过bin/startup.sh启动tomcat 即可。



## 使用技術
- 使用J2EE課上教的Servlet + jsp

## 數據庫
- 建表命令 src/main/sql/database.sql
- 數據 src/main/sql/initdatabase.sql
- hibernate的配置文件在 src/main/resources文件夾下
- 
