------

# 项目字段设计

```
Theme  Hashmap(name  simpName )
Doraemon
Beast Wars
Role    name  simpName          boolean laugh

Doraemon
NormalChinese
GuangDongChinese

Beast Wars
巨无霸Maximal
原始兽Predacon
```

[^备注]: Theme把每部动画片都共有的动画片名称、队伍名称、人物map、getName()、start()都包括了；新增动画片就直接继承即可



# 前端模板

thyemleaf是模板引擎，旨在代替JSP，而本item找寻的是模块框架类似于AdmainLTE帮我们备好了页面模板

//jsp模板
AdminLTE：
LTEDocument：https://adminlte.io/docs/3.1//index.html
AdminLTE使用：编译后，把静态资源放入，修改相应的模板页面     baidu：https://www.pianshen.com/article/68441412388/
Gentelella：Gentelella模块不用npm?
https://github.com/ColorlibHQ/gentelella
Document：https://colorlibhq.github.io/gentelella/
//vue模板
ng2-admin：
后台管理模板：https://github.com/akveo/ngx-admin              //启动脚本命令：npm start
Document：https://akveo.github.io/nebular/docs/guides/install-based-on-starter-kit#install-based-on-starter-kit
但是该模板使用的语言是angular



------

# 数据库设计

| 表                         | 字段 |          |                     |         |                                                              |      |
| :------------------------- | ---- | -------- | :-----------------: | ------- | ------------------------------------------------------------ | ---- |
| theme主题表                | id   | name     |                     |         |                                                              |      |
| team队伍表                 | id   | theme_id |        name         |         |                                                              |      |
| team_role角色表            | id   |          |                     |         |                                                              |      |
|                            |      |          |                     |         |                                                              |      |
| voice_classified声音分类表 | id   | name     |                     |         | //声音分类：经典Voice、笑声、Others                          |      |
| voice表                    | id   | role_id  | voice_classified_id | address | //声音：声音分类id、声音字符串，其中对应的Entity类的属性名为voiceClassifiedId、address存放voice的项目相对位置 |      |
|                            |      |          |                     |         |                                                              |      |
| log表                      | id   |          |                     |         |                                                              |      |
|                            |      |          |                     |         |                                                              |      |
| user表                     | id   | username |      password       |         |                                                              |      |
| role表                     | id   | rolename |                     |         |                                                              |      |
| user_role表                | id   | user_id  |       role_id       |         |                                                              |      |





------

# 音乐播放：

- **a.jsp没有声音**			应该是项目jsp不能读取项目外部的文件，应把文件引进来，理由：b.html在项目外可以播放而在项目内却不能

- **如何在webapp写文件的相对位置**            src="${pageContext.request.contextPath}/img/user2-160x160.jpg"，但还是不能播放，可能是文件资源需要编译  

- **英语模板html使用项目的url就不能访问**           可能是前端资源没有编译?需要学习前端编译，前端资源怎么放在javaweb项目上  ：已sloved，答案在上条problem

- **已经把文件放在项目内部，但还是不能访问资源，播放音乐**            springmvc配置了可以访问的静态资源，springsecurity配置了哪些静态资源不被拦截，把静态资源设置为可访问、不被拦截，或者设置静态资源位置即可

- **有没有jsp音乐播放模板页面**      

  

  

------

# 项目指导：

改用vue：1. 得解决上面繁杂问题、2.guli可以使用到、3.vue样式新模板多

不用vue因为得学很多vue知识、不用jsp因为没有相应后台与音乐模板页面、不用thymeleaf因为没有任何模板页面，而是使用最普通的javaweb工程，因为有html音乐播放模板
直接后端，采用swagger测试，前台音乐播放使用html模板，后台管理使用vue模板
前台音乐播放使用vue因为相比html、jsp、thymeleaf方便与后端交互，同时jsp、thymeleaf不能播放音乐，html太简陋

##                   vue播放音乐：

黑马程序员实现vue获取网易云音乐资源进行播放：https://www.bilibili.com/video/BV12J411m7MG?p=32





------

# 前端vue：

## vue.js是什么：

vue解决了html+css+js的诟病
vue是一款JavaScript框架，建立在html+css+javascript基础上的框架，编译后依然是同左这些基础元素
vue解决了什么问题：https://blog.csdn.net/wxl1555/article/details/79964818 
其中vue.js与node.js不是同一等级的，node.js是javascript的运行环境，旨在让javascript脱离浏览器运行，node.js相当于前端服务器

## nuxt.js是什么：

nuxt提高了页面响应速度，提升用户体验
nuxt.js是一个基于vue.js的轻量级应用框架，可用来创建服务端渲染(SSR)应用提高页面的响应速度，相当于spring一样的框架

前端渲染：页面获取服务端数据后，再在前端进行数据填充渲染
服务端渲染：页面获取服务端数据后，在服务端进行数据填充渲染后，再返回给前端
npx create-nuxt-app或使用使用模板start-template都是创建最基础的nuxt模板，而express等模板是最基础的nuxt模板再封装

## UI框架是什么：

vue-ui框架指基于vue框架上开发的界面框架			UI：User Interface用户界面，UI设计指界面美化设计
我们可以在vue框架nuxt上安装vue ui框架：Element-Ui、Vuetify、Quasar

## 项目指导：

nuxt是一个基于vue的轻量级应用框架，其中vue解决了html+css+js的诟病，nuxt方便了前后端分离开发，而学习vue只是学习vue页面代码的语法，使用nuxt方便与后端交互，直接使用vue相当于从一个.vue文件开始搭建，应该学习的是vue框架nuxt

## 后台模板选择要求：

必须基于vue因为方便前后端分离，其中使用什么vue框架或vue-ui框架无所谓

后台模板暂定使用guli后台模板vue-admin-template，其中有教学Document
后台模板都是基于一定语言与框架开发的模板，ForE： guli后台模板vue-admin-template使用了语言vue+ui框架element-ui              

## vue项目怎么和springboot项目交互：

utils/request.js保存nginx的端口，api/.js创建各种方法访问后端的url接口，nginx+api=http://localhost:9001+/eduservice/coursefront/getFrontCourseInfo
在页面上使用<script>，import文件api/.js，访问页面就会触发<script>使用***.js的方法触发访问后端url获得数据

## 使用vue搭建还是nuxt搭建还是nuxt+express?

使用nuxt框架搭建前后端交互，引入ui框架修饰

## vue页面怎么写资源的相对位置

​              
​               

------

# swagger√：                 



------

# 日志：



------

# 定时任务：



------

# 设计模式：

项目里怎么使用设计模式：项目怎么设计才可扩展而不是必须使用什么设计模式

父类Theme实体类、父类Team实体类、子类Role实体类：new Role()可以带上上层的数据，但是直接使用另一个表，用id关联不更好吗？即Rode实体类有Team实体类的id，Team实体类有Theme实体类的id，相当于代码里的设计模式转移到数据库里



------

# Cloud：



------

# Redis：



------

# 登录OAuto2：



------

# 消息队列：

添加角色后即可返回结果给用户，把添加的任务放在消息队列

