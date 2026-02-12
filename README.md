# Carpet_CuO_Addition
*闲着没事写的一个地毯扩展*

*不要问我为什么起这个名字*
## 依赖
| 名称         | 类型 |
|------------|----|
| carpet     | 必须 |
| fabric-api | 必须 |
## Rules
### (最大连锁更新深度)maxChainDepth
更改`maxChainDepth`字段的值，即服务器配置文件中`max-chained-neighbor-updates`的值

* 默认值：`1000000`
* 选项：`0`，`65535`，`1000000`，`2147483647`
### (无限开宝库)infinitelyVault
玩家可以无限的开启宝库
仅限该玩家未开启过的宝库

* 默认值：`false`
* 选项：`false`，`true`
### (比较器复制修复)comparatorDupeFix
修复比较器复制（*其实就是在调用Comparator.update()时判断自身是否是空气*）

* 默认值：`false`
* 选项：`false`，`true`
### (最大更新深度)maxUpdateDepth
修改形参`maxUpdateDepth`的值

* 默认值：`512`
* 选项：`0`，`512`，`1000000`，`2147483647`
### (树叶和苔藓可作为燃料)useLeavesAndMossAsFuel
可以使用树叶类方块和苔藓块作为熔炉燃料使用

1.21.2+需要重启服务器使更改生效

* 默认值：`false`
* 选项：`false`，`true`
### (无限图腾)infinitelyTotem
无限使用图腾

* 默认值：`false`
* 选项：`false`，`true`
### (没有附魔等级上限)noEnchantmentLevelLimit
没有附魔等级上限

这意味着你可以在铁砧上敲出的附魔等级最高为255

建议搭配noTooExpensive食用

* 默认值：`false`
* 选项：`false`，`true`
### (没有过于昂贵)noTooExpensive
开启后过于昂贵需要的等级不再是40，而是int上限

* 默认值：`false`
* 选项：`false`，`true`
### (显示连锁更新深度)showChainUpdateDepth
开启后若更新链的depth超过了10万就会打印到聊天栏中

* 默认值：`false`
* 选项：`false`，`true`
### (铜傀儡修复)copperGolemFix
版本：1.21.9+

开启后铜傀儡不会再在空气中变为雕像

~~不知道麻将是不是故意这样设计的~~

* 默认值：`false`
* 选项：`false`，`true`
### (重新引入方块实体替换)blockEntitySwapReintroduced
版本：1.21.4-

开启后加载区块时不会再检查方块实体是否合法，放置一个带方块实体的方块时也不会再删除原来坐标的方块实体

1.21.5之后破坏大部分方块会先删除方块实体再放出更新，这导致无法保存方块实体

* 默认值：`false`
* 选项：`false`，`true`
### (末地门框架可以被挖掘)endPortalFrameCanBeMined
可以挖掘末地传送门框来获取物品形式的末地门框

* 默认值：`false`
* 选项：`false`，`true`