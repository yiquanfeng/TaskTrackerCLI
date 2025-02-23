## progress
add 命令基本完工

## target
- 使用json作为存储配置文件
  - org.json
- json字段
  - nums
  - Descriptions
  - Status
  - CreatedAts
  - UpdatedAts
- cli基本编写
  - add -- ok
  - update
  - delete
  - mark-in-progress
  - mark-don
  - list <options>


# result
## how to use cli operation
使用``java -cp "./target/classes;C:\Users\yiquanfeng\.m2\repository\info\picocli\picocli\4.7.5\picocli-4.7.5.jar" task-cli ..``  
来运行命令行程序，在类unix系统中可以设置alias，在windows系统中可以在powershell中的profile中配置Set-Alias.

## basic command
taskcli add <task content>
