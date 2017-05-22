# DataBindingDemo
Android开发DataBinding数据绑定demo  
### 目录  
#### simple：
DataBinding基本用法、常量、变量、事件的绑定，ViewStub、include的使用演示。
#### setter：
DataBinding中BindingMethods、BindingAdapter、BindingConversion、InverseBindingAdapter等Setter的使用演示。  
#### twoway：
DataBinding中双向绑定的用法演示。
#### lambda：
Lambda表达式的基本使用方法演示。  
#### animation：
DataBinding中使用动画的方法演示。 
#### recycler：
RecyclerView+DataBinding实现列表视图的绑定演示。  
### 遇见问题  

#### 问题1：  
使用BindingAdapter时如果设置`@BindingAdapter({"app:imageUrl", "app:placeholder"})`会导致找不到setter错误。  
#### 解决方法：
`@BindingAdapter({"imageUrl", "placeholder"})`


