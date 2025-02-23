## progress
现在要先搞定文件io才可以将一切进行下去，cli的基本环境已经配置好了


## target
- 使用json作为存储配置文件  
  - 文件io
  - json操作库---org.json
- json字段
  - nums
  - tasks
    - id
    - description
    - status
    - createdAt
    - updatedAt
- cli基本编写
  - add
  - update
  - delete
  - mark-in-progress
  - mark-don
  - list <options>


## result
使用``java -cp "./target/classes;C:\Users\yiquanfeng\.m2\repository\info\picocli\picocli\4.7.5\picocli-4.7.5.jar" task-cli ..``  
来运行命令行程序，在类unix系统中可以设置alias，在windows系统中可以在powershell中的profile中配置Set-Alias.

