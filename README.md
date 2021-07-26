# KeyValueView
在某些领域键值对的表单特别多,不停的复制粘贴让人难以忍受.
现在只需要给定一组Key-Value就可以高效完成表单,对于不同设计稿这并不是很完善,在使用中可能需要做一些小小的修改.
## UI

 <img src="https://user-images.githubusercontent.com/10151414/127034208-5aedca27-77cf-4b58-bcb2-e52d18409cc2.png" alt="hello" style="zoom:67%;"/>

## 快速开始
像普通的View控件一样使用
### 1.  layout
```xml
<com.unistrong.myapplication.KeyValueView
    android:id="@+id/keyValueView"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:padding="8dp" />
```
### 1.  java or kotlin
##### kotlin
```kotlin
        val keyValueView = findViewById<KeyValueView>(R.id.keyValueView)
        keyValueView.data = mutableListOf(
            KeyValue("姓名：", "张三", "年龄：", "22"),
            KeyValue("身份证号码：", "115415612484215984"),
            KeyValue("家庭住址：", "黄头高坡坡北石头凹村"),
            KeyValue("婚姻状况：", "已婚", "配偶：", "李小凤"),
            KeyValue("联系电话：", "18898866988"),
        )
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
```java
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

