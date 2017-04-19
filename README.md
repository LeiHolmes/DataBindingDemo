# DataBindingDemo
Android开发DataBinding数据绑定demo  
### 问题1：  
使用BindingAdapter时如果设置`@BindingAdapter({"app:imageUrl", "app:placeholder"})`会导致找不到setter错误。  
### 解决方法：  
`@BindingAdapter({"imageUrl", "placeholder"})`
