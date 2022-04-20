# campus-bbs

**TODO**

* 帖子列表（加分页器） 完成
* 水楼和回复界面（加返回和分页器）
* 把表格和楼层弄成斑马纹  （不必要）
* 连接前后端



**后端**

spring

spring boot



VS code



Intellij IDEA



**前端**

npm

yarn

node

vue

* element-ui
* vue-cli
* less
* less-loader
* vue-router
* axios
* vuex
* （不知道有没有漏）



**数据库**

Mybatis

Mysql



Data Grip



**启动**

前端 

```
npm run serve
```

后端

```
运行就行
```





**普通用户**

* 可以找到不同板块
* 可以查看帖子列表
* 可以对帖子进行排序
* 可以发帖
* 可以回复（富文本）
* 可以匿名
* 可以设置头像
* 可以改名字
* 可以改密码
* 可以注销
* 可以搜索帖子
* 可以关注其他用户
* 可以接受关注用户动态
* 可以删除关注你的用户
* 需要学校邮箱注册
* 需要登录进入网站



**管理者**

* 删除帖子
* 封禁用户
* 设置版主（打算去掉）
* 撤销版主（打算去掉）



（打算去掉）

版主：

* 置顶相应版块帖子
* 删除相应版块帖子
* 封禁相应版块帖子
* 封禁用户
* 删除回复



**数据库**

user：

* id   int
* 权限类型（0普通，10管理员）
* 学号
* 用户名
* 密码
* 头像
* comments（不用在表里建）
* 关注列表（publisher）（不用在表里建）
* 粉丝列表（subscriber）（不用在表里建）
* 发帖数column_6
* 最近活跃
* 创建时间



板块：

* id
* 名字
* post列表（不用在表里建）



post：

* id
* 名字
* 板块（需要在表里建）
* 分区（暂时不需要在表里建）
* 创建者（需要在表里建）
* 点击量
* comments（不需要在表里建）
* 是否允许匿名
* 最新回复时间
* 创建时间



comment：

* id
* 所属板块（需要在表里建）
* 所属帖子（需要在表里建）
* 内容
* 发表者（需要在表里建）
* 发表时间
* 是否匿名
* 是否可见
* 是否是回复

 

relation：

* up
* 粉丝



user_follow（多对多）

user_post（一对多）

user_comment（一对多）

post_comment（一对多）

section_post（一对多）

好像没了





（漏了一个搜索，记得加一下）（已完成）

 ![image-20220228094844253](C:\Users\25328\AppData\Roaming\Typora\typora-user-images\image-20220228094844253.png)

(已完成)

 ![image-20220228095454638](C:\Users\25328\AppData\Roaming\Typora\typora-user-images\image-20220228095454638.png)

（已完成）

 ![image-20220228101118744](C:\Users\25328\AppData\Roaming\Typora\typora-user-images\image-20220228101118744.png)

（已完成）



vue 传递参数

https://blog.csdn.net/tianxintiandisheng/article/details/82463883





大致流程

（已经完成的）

* 调研，看看其他论坛长什么样子，有什么功能（看了北大未名，北邮人论坛，cc98，放点图）
* 设计用户故事，有什么用户，需要什么功能（上面有，copy一下）
* 设计数据库表单，并在mysql中建立数据库和表单（上面有，copy后再贴张图）
* 用软件画前端草稿，并用vue实现前端（画图好难看）
* 后端连接数据库和CRUD的demo

（还没完成的）

* 用spring boot实现后端（看起来简单）
* 完善功能，相应的调整前端（没想好要加什么功能）
* 测试，然后注册域名，上线看看



ppt怎么搞，怎么答辩....（建议参照自查表）

* 背景，调研（放点图）
* 前端用到的库和演示
* 放点数据库的图



Are the purpose and rationale of the project stated clearly?
Are the advantages of the proposed work justified?
Are the project aims and objectives clearly stated?
Does it show knowledge of the research, theory, concepts, ideology, and opinion related to the topic?
Is there any critical assessment of the reviewed literature?
Is the relationship between what others have done and what is proposed in this project explained?

Have the main project aims and objective been identified? 
Have the main challenges been highlighted?
Is the proposed methodology technically sound?

Are the variables / parameters in the study / experiment identified and described?
Is the proposed design / lab procedure the most suitable after having performed the literature review?
Are modern tools/equipment/software used in the design / lab methodology indicated?
Does each table/figure/chart stand on its own, clear and self-explanatory?
How was the raw data summarised? Descriptive statistics? Content analysis? Other?
Are there any analyses or explanation behind any unforeseen results?





* 计划的目的和理据是否已清楚说明?

  emm

* 所提议的工作的优点是否合理?

  很合理阿

* 计划的目的和目标是否清楚地陈述?

  提供一个交流平台呗

* 它是否显示了与主题相关的研究、理论、概念、意识形态和观点的知识?

  （这个搞一下）

* 是否有任何评论的文献评估?

  文献？

* 是否解释了其他人所做的与本项目所提议的内容之间的关系?

  主要是模仿，我不搞创新。



* 项目的主要目标和目的是否已确定?

  上线一个论坛

* 主要的挑战被强调了吗?

  实现论坛各种功能

* 建议的方法在技术上是否合理?

  当然了，工业界都这么干的。



* 研究/实验中的变量/参数是否被识别和描述?

  emm，用户故事和数据库表算不算

* 在进行了文献综述之后，建议的设计/实验室程序是否最合适?

  合适极了

* 在设计/实验室方法论中是否使用了现代工具/设备/软件?

  Idea 和 vscode

* 每个表格/图/图是否独立存在，清晰且不言自明?

  你说呢？？？

* 原始数据是如何总结的?描述性统计?内容分析?其他的吗?

  后端还没搞呢！！

* 对于任何未预见到的结果，是否有任何分析或解释？

  不是理论性的阿，bug都被de了













* 绪论
  * 背景和目的
  * 调研

* 工作进展
* 系统设计
  * 前端
  * 数据库

* 使用工具
  * 前端
  * 后端
  * 数据库
* 问题和解决方案





**后端来喽**

postman测试CRUD

![image-20220418154109638](C:\Users\25328\AppData\Roaming\Typora\typora-user-images\image-20220418154109638.png)

错误码500是sql语句出错，后端项目会停止。



springboot中的entity实体中的属性，需要把数据库表单中下划线_变成驼峰规则，这样命名的变量才可以被识别.......（日了狗了）



github毕业设计项目的的token

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