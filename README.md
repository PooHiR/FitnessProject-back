# 大三下web框架课程设计

### 健身房会员管理系统

#### 部署步骤：

本项目是前后端分离项目，分为前端、后端

##### 前端部署步骤如下

您可在idea或者vs code等任何编辑器中打开vue目录
首先进入到vue这个目录下，打开终端，输入

```shell
npm install
```

如果显示“没有npm命令”等提示，请先检查node是否安装好，环境变量是否配置好

接着会进行包的下载，下载完成后可以对前端进行运行，终端输入

```shell
npm run serve
```

如果提示错误，可以对照一下我的node版本，我的node版本是v16.17.0 npm版本是9.6.6，正常情况下会为您展示前端项目的地址

##### 后端部署步骤如下

首先在数据库管理工具新建gym_management数据库，导入提供的sql文件

IDEA打开springboot目录，打开src/main/resources/application.properties文件

```
spring.datasource.username=root
spring.datasource.password=你的数据库密码
```

然后配置一下maven（maven安装以及修改源等自行找教程），在右边栏中找到maven，然后点击扳手图标选择maven设置，修改maven主路径，用户设置文件、本地仓库成你自己的。

项目的SDK选1.8，项目的文件编码设置成UTF-8。

找到 [DemoApplication.java]直接运行即可



