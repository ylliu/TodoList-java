# TodoList-java
郑烨老师的代码之丑课程的练习，课程链接：    
https://time.geekbang.org/column/intro/382       

## 构建
运行Client下的main函数，循环输入指令   
todo add item
todo done <index>    
todo list    
todo list --all   

## 运行效果    
todo add play1    
1.play1    

Item 1 added   
>
todo add play2    
2.play2    
  
Item 2 added
> 
todo add play3    
3.play3 

Item 3 added    
>    
todo done <1>    
Item 1 done     
>    
todo done <3>    
Item 3 done    
>    
todo list    
2.play2   
Total: 1 item    
>    
todo list --all    
1.[Done] play1    
2.play2     
3.[Done] play3    
Total: 3 items,2 items done

 
