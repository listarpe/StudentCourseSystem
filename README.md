## 注意事项

1. 数据库为```Mysql ```，需自行添加相应jar。

2. 在使用前需用```scr/config```中提供的sql脚本```StudentSystem.sql```来创建一个数据库。

3. 连接数据库所需的配置信息在```scr/config```中的```config.properties```中填写。

4. 按钮点击反应不是很灵敏，有时需要多次点击。

## 运行方法

运行```scr/main```中的```main.java```。

## 主要功能

在学生模块中可以执行添加学生、删除学生、查询成绩、选退课操作。

在课程模块中可以执行添加课程、删除课程、查询选课学生、登分操作，其中登分操作包含在查询选课学生中。

## 界面展示

在运行程序后，首先会弹出登录界面

<img src="C:\Users\Rogue\Pictures\学生管理系统\Snipaste_2021-07-04_11-56-13.png" alt="Snipaste_2021-07-04_11-56-13" style="zoom: 67%;" />

只有用已录入的学生学号和管理员账号```admin```可以登入，密码默认为123456。如果使用其他账号或密码错误，会提示”登录失败“。

<img src="C:\Users\Rogue\Pictures\学生管理系统\Snipaste_2021-07-04_15-38-19.png" alt="Snipaste_2021-07-04_15-38-19" style="zoom: 67%;" />

### 1.学生模块

使用学生学号登录成功，可以使用”查询成绩“和”选课“两个功能。

<img src="C:\Users\Rogue\Pictures\学生管理系统\Snipaste_2021-07-04_15-40-08.png" alt="Snipaste_2021-07-04_15-40-08" style="zoom:67%;" />

点击”查询成绩“，显示：

<img src="C:\Users\Rogue\Pictures\学生管理系统\Snipaste_2021-07-04_15-41-16.png" alt="Snipaste_2021-07-04_15-41-16" style="zoom: 67%;" />

-1表示尚未录入成绩。

点击选课，显示：

<img src="C:\Users\Rogue\Pictures\学生管理系统\Snipaste_2021-07-04_15-43-38.png" alt="Snipaste_2021-07-04_15-43-38" style="zoom:67%;" />

可以进行”选课“、”退课“操作。

### 2.管理员模块

使用管理员账号```admin```登录，可以使用全部功能：

<img src="C:\Users\Rogue\Pictures\学生管理系统\Snipaste_2021-07-04_15-46-06.png" alt="Snipaste_2021-07-04_15-46-06" style="zoom: 50%;" />

点击”添加“，输入相关信息，点击”确定“，可以添加学生：

<img src="C:\Users\Rogue\Pictures\学生管理系统\Snipaste_2021-07-04_15-47-35.png" alt="Snipaste_2021-07-04_15-47-35" style="zoom:67%;" />

选中学生，点击”删除“，即可将学生删除。

选中学生，点击”查询成绩“和”选课“，可以实现和学生模块相同的功能。

点击上方的标签页，可以切换学生和课程。

<img src="C:\Users\Rogue\Pictures\学生管理系统\Snipaste_2021-07-04_15-49-45.png" alt="Snipaste_2021-07-04_15-49-45" style="zoom:50%;" />

同样，可以实现”添加“和”删除“课程的功能。

选中课程，点击”查询学生“，可以查看选这门课的所有学生：

<img src="C:\Users\Rogue\Pictures\学生管理系统\Snipaste_2021-07-04_15-51-55.png" alt="Snipaste_2021-07-04_15-51-55" style="zoom:50%;" />

选中学生，点击”登分“，可以给学生录成绩：

<img src="C:\Users\Rogue\Pictures\学生管理系统\Snipaste_2021-07-04_15-53-23.png" alt="Snipaste_2021-07-04_15-53-23" style="zoom:50%;" />



201930124031  冯立
