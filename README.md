# TodoList-java
TodoList practise
## 第一阶段
+ 添加Todo项
```java

todo add <item>


1. <item>


Item <itemIndex> added
```

+ 完成Todo项
```java

todo done <itemIndex>


Item <itemIndex> done.
```

+ 查看 Todo 列表，缺省情况下，只列出未完成的 Todo 项
```java

todo list


1. <item1>
2. <item2>


Total: 2 items
```

+ 使用 all 参数，查看所有的 Todo 项
```java

todo list --all


1. <item1>
2. <item2>
3. [Done] <item3>


Total: 3 items, 1 item done
```

要求：
1. Todo 项存储在本地文件中；
2. Todo 项索引逐一递增。
