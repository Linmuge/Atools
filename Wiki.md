### 简介[ [UI](https://github.com/Gushenge/Atools/wiki/Ui) and [Util](https://github.com/Gushenge/Atools/wiki/Util) ]
###### Atools是一款集成大部分安卓开发所必需的小工具类的框架，它可以使我们的开发过程更为快速，目前主要包含[Ui](https://github.com/Gushenge/Atools/wiki/Ui)和[Util](https://github.com/Gushenge/Atools/wiki/Util)两大类

### 使用方法
###### kotlin  
    implementation 'com.gushenge.atools:kotlin:last-release' 
###### java  
    implementation 'com.gushenge.atools:java:last-release'
    
注: last-release为最后一个版本，具体请查看 [README.md](https://github.com/Gushenge/Atools/blob/master/README.md)
### 说明
##### App的targetSdkVersion应大于或等于23
###### 如果需要使用Ui类，项目必须包含
    implementation 'androidx.appcompat:appcompat:last-release'
###### 如果使用kotlin库，则必须包含
    implementation"org.jetbrains.kotlin:kotlin-stdlib-jdk7:last-release"
    implementation 'androidx.core:core-ktx:last-release'
**注: java版本没有任何限制**
###### 如果Ui库使用Anko的方式导入，则必须包含
    implementation "org.jetbrains.anko:anko:last-release"
    
### 这个框架目前还在开发以及完善阶段，希望各位路过的大佬们给予一定的建议以及指导
### 感激不尽
### 如需新增功能以及修复之前的bug请提 [Issue](https://github.com/Gushenge/Atools/issues)或发邮件至 
### [Gmail](cikexiaosi@gmail.com) ：cikexiaosi@gmail.com
### [QQ邮箱](1206083231@qq.com) ：1206083231@qq.com