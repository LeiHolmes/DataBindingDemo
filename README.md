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
[可参考我写的博文教程](http://xulei.tech/2017/05/15/Android%E5%BC%80%E5%8F%91%E4%B9%8BDataBinding%E5%9F%BA%E6%9C%AC%E5%AE%9E%E7%8E%B0/)
  


