# KeyValueView [![](https://jitpack.io/v/RUANHAOANDROID/KeyValueView.svg)](https://jitpack.io/#RUANHAOANDROID/KeyValueView)
在某些领域键值对的表单特别多,不停的复制粘贴让人难以忍受.
现在只需要给定一组Key-Value就可以高效完成表单,对于不同设计稿这并不是很完善,在使用中可能需要做一些小小的修改.
## 功能
- 行键值对显示
- 键最小宽度
- 双键值对宽按百分比显示
- 键值对Value跨行显示（最多支持2行,行中不可以再设置第二个键值对）
- 单视图使用
- 列表中使用

## 预览
<table>
       <tr>
            <td align="center">单独使用</td>
            <td align="center">列表中使用</td>
	    <td align="center">跨行显示</td>
        </tr>
    <tr>
      <td>
          <img src="https://user-images.githubusercontent.com/10151414/127117139-fdde2cd8-6e26-4cc7-be07-c8dfa2c0c47d.png" alt="hello" style="zoom:67%;"/>            
        </td>
        <td>
          <img src="https://user-images.githubusercontent.com/10151414/127116874-6e58a25d-77a4-40b5-9915-f18740b0bc2b.png" alt="hello" style="zoom:67%;"/>
      </td>
	     <td>
          <img src="https://user-images.githubusercontent.com/10151414/149767487-f260d246-3198-493c-8d3a-b7d93af0f1fa.jpg" alt="hello" style="zoom:67%;"/>
      </td>
    </tr>
</table>

## 快速开始
### 1. include
```gradle

    allprojects {
	repositories {
		maven { url 'https://jitpack.io' }
	}
    }
	
    dependencies {
    	implementation 'com.github.RUANHAOANDROID:KeyValueView:1.0.2'
    }
```
### 2. layout
```xml
<com.keyvalue.view.KeyValueView
    android:id="@+id/keyValueView"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:padding="8dp" />
```
### 3. kotlin or java  
##### kotlin
``` kotlin
        val keyValueView = findViewById<KeyValueView>(R.id.keyValueView)
	//设置数据
        keyValueView.data = mutableListOf(
            KeyValue("姓名：", "张三", "年龄：", "22"),
            KeyValue("身份证号码：", "115415612484215984"),
            KeyValue("家庭住址：", "黄头高坡坡北石头凹村"),
            KeyValue("婚姻状况：", "已婚", "配偶：", "李小凤"),
            KeyValue("联系电话：", "18898866988"),
        )
	//可选的样式设置
        keyValueView.itemStyle.apply {
            height = 30f
            percentage = 0.6f
        }
        keyValueView.keyStyle.apply {
            textColor = android.R.color.holo_red_dark
            textSize = 16f
        }
        keyValueView.valueStyle.apply {
            textColor = android.R.color.holo_blue_dark
            textSize = 16f
        }
        keyValueView.invalidate()
```
##### java
``` java
        KeyValueView keyValueView = findViewById(R.id.keyValueView);
        List<KeyValue> data = new ArrayList<>();
        data.add(new KeyValue("姓名：", "张三", "年龄：", "22"));
        data.add(new KeyValue("身份证号码：", "115415612484215984", null, null));
        data.add(new KeyValue("家庭住址：", "黄头高坡坡北石头凹村", null, null));
        data.add(new KeyValue("婚姻状况：", "已婚", "配偶：", "李小凤"));
        data.add(new KeyValue("联系电话：", "18898866988", null, null));
        keyValueView.setData(data);
        //通常情况下不需要额外设置style
        ItemStyle itemStyle = new ItemStyle();
        keyValueView.setItemStyle(itemStyle);
        KeyStyle keyStyle = new KeyStyle();
        keyValueView.setKeyStyle(keyStyle);
        ValueStyle valueStyle = new ValueStyle();
        keyValueView.setValueStyle(valueStyle);
```

