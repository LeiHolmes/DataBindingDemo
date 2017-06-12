### DataBinding简介  
　　DataBinding是基于MVVM思想实现数据与UI绑定的框架，有了Data Binding，在Android中也可以很方便的实现MVVM。它于2015年7月由Google在Studio1.3上引入，2016年4月在Studio2.0上得到正式支持。DataBinding是一个support库，最低支持到Android2.1（API Level 7+）。
<!--more-->
　　在引入DataBinding之前，我们需要敲很多很鸡肋的代码，如 findViewById()、setText()，setVisibility()，setEnabled() 或 setOnClickListener() 等，通过 DataBinding , 我们可以通过声明式布局以精简的代码来绑定应用程序逻辑和布局，这样就不用编写大量的冗余的代码了。这一节我们来讲一讲DataBinding的基本实现之常量绑定、变量绑定与事件绑定。
### 初始化
#### 在build.gradle中添加
```java
android {
    dataBinding {
        enabled = true;
    }
    ......
}
```
#### 在xml文件最外层结构添加
```xml
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools">
    ......
</layout>
```
　　即是将最外层标签改为`<layout></layout>`   
#### 替换原setContentView方法
```java
ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
```
　　**命名规则**：这里的ActivityMainBinding命名由来是其layout名称转换为驼峰形式再加上"Binding得到"。例如activity_main->ActivityMainBinding。
### 开始绑定
#### 常量绑定
　　在xml中：
```xml
<TextView
    android:id="@+id/text_view1"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content" />
```
　　在Activity中：
```java
binding.textView1.setText("Helloworld");
```
　　**命名规则**：控件id带下划线时，调用时使用其id的驼峰命名形式 。不带下划线时，调用时与id一致。例如id为text_view1，调用时使用binding.textView1。
#### 变量绑定
　　首先创建一个简单的数据来源类MyBean：
```java
package com.sherlock.databindingdemo;

public class MyBean {
    private String name;
    private int age;
    
    public MyBean(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
}
```
　　然后在xml文件layout标签下添加：
```xml
<data>
    <variable
        name="mybean"
        type="com.sherlock.databindingdemo.MyBean" /> 
</data>
<!--name：提供数据的bean的别名；type：bean的类名-->
```
　　在控件中设置变量绑定：
```xml
<TextView
    android:id="@+id/text_view1"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_marginRight="10dp"
    android:text="@{mybean.name}"/>
```
　　在Activity中设置数据：
```java
binding.setMybean(myBean);
//binding.setVariable(BR.mybean,myBean);		//另一种方法
```
　　**注意**：`@{mybean.name}`中的name必须为String类型，若要绑定别的类型，比如int类型，可以这样`@{String.valueOf(mybean.age)}`。
#### 事件绑定
　　当然我们也可以用DataBinding实现事件绑定，它有两种实现方式。
　　**第一种**：首先添加一个事件回调类Presenter，这里演示Click与TextChange事件:
```java
public class Presenter {
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        myBean.setName(s.toString());
        binding.setMybean(myBean);
    }
    public void onClick(View view){
        Toast.makeText(MainActivity.this, "点击成功", Toast.LENGTH_SHORT).show();
    }
}
```
　　**注意**：使用这种事件绑定方式，Presenter中的方法需和控件监听方法完全一致。  
　　在xml中：
```xml
<data>
    <variable
        name="presenter"
        type="com.sherlock.databindingdemo.MainActivity.Presenter" />
</data>

<EditText
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:onTextChanged="@{presenter.onTextChanged}" />
    <!--或者@{presenter::onTextChanged}-->

<Button
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:onClick="@{presenter.onClick}" />
    <!--或者@{presenter::onClick}-->　　
```
　　在Activity中：
```java
binding.setPresenter(new Presenter());
```
　　**第二种**：也可以设置自定义的监听器Binding，可回传参数，需要使用Lambda表达式：
　　在xml中：
```xml
<Button
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:onClick="@{() -> presenter.onButtonClick(mybean)}" />
    <!--或者@{(view) -> presenter.onButtonClick(mybean)}-->
```
　　在Presenter中：
```java
public void onButtonClick(MyBean myBean){
    Toast.makeText(MainActivity.this, myBean.getName(), Toast.LENGTH_SHORT).show();
}
```
　　**注意**：使用这种事件绑定，Presenter中的监听方法就不需要与View的监听方法完全一致了，而且可以获取View在事件中回传的数据。
### 总结
　　这一节到此DataBinding的常量，变量，事件绑定的用法就讲解完毕了，实际操作起来感觉目前AndroidStudio对DataBinding的支持还不够，排错有点费劲，有时会出现找不到DataBinding的错误，这时应先查看下是否由于自己修改了某个类名，而xml调用时没有修改导致。若没有问题则删除app下的build文件夹重新Rebuild下项目试试。  
  
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



