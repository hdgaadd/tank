操作数operand       [ˈɒpərænd]
转换converted     [kənˈvɜːtɪd]
不相容的incompatible    [ˌɪnkəmˈpætəbl] 
非法的illegal    [ɪˈliːɡl]
声明statement     [ˈsteɪtmənt]
二进制的binary    [ˈbaɪnəri]
举例instantiate   [ɪnˈstænʃɪeɪt]
复杂性complexity  [kəmˈpleksəti]
翻转reverse       [rɪˈvɜːs]        Colleacions.reverse(List<?> list)
预期expected     [ɪkˈspektɪd] 








Java中单例模式定义：一个类有且仅有一个实例
单例模式两种构建方式：懒汉式、饿汉式

事务四个特性：原子性、一致性、隔离性、持久性

Java中的23种设计模式：Factory（工厂模式)、Singleton（单例模式）、Observer（观察者模式）

Java序列化就是指把Java对象转换为字节序列的过程
Java反序列化就是指把字节序列恢复为Java对象的过程。

冯诺依曼体系结构：CPU处理器、运算器、存储器（ RAM， ROM等 ）输入设备、输出设备五部分组成

多态就是继承同一个抽象类，使用不同的实例而执行不同操作
例如我们声明一个喝酒的抽象类，它有一个方法是喝酒，两个子类各有一个方法是喝茅台、喝葡萄酒，
此时我们实例喝茅台的子类就会执行喝茅台，实例喝葡萄酒的子类就会执行喝葡萄酒

悲观锁使用数据库本身的锁机制，会锁记录
乐观锁是一种不锁记录的实现方式，使用CAS模式，对数据进行更新时，会version+1,并保存该值，在提交更新操作时，如果该值被改变了，则更新失败

Mysql性能优化
添加索引，查询1000w条数据，使用普通查询要一条一条插，使用索引就像书有目录一样，可以直接到达索引的位置，大大提高了查询效率
索引的数据结构有:hash(键值对)、BTree(二叉树)、RTree、FullText(全文索引)
为临时表添加足够多的内存

--------------------------------------------------------------------------------------------
# 算法方法论

交换位置
双指针  数组:int i=0;int k=arr.length-1;i、k是该数组的双指针    双指针可以左0右n-1,也可左0右0
辅助栈 辅助队列 辅助链表
一次次加和一次性加
数组先排好序
善用for(int i:arr){}
根据要求找出满足条件
多少种可能性的题目一般都有递推性质，即f(n)和f(n−1)…f(1)之间是有联系的 
二进制算法题,按每个位之间的关系来设计算法
辅助辅助辅助，而for、while
递归dfs(TreeNode left,TreeNode right)，丢两个去比较，而不是只丢一个，然后使用root.left和root.right去比较









--------------------------------------------------------------------------------------------
# 算法总结

算法：动态规划、深度优先搜素、广度优先搜素、分治算法、贪心算法、回溯、
数据结构：数组、集合、链表、树、图、栈、队列、堆
解释特殊问题：摩尔投票法、斐波那契、子集、组合、前缀和、二维数组最短路径

空间复杂度：如果有递归，为递归深度，即递归结束条件n

public void help(char[] ch,int num,ArrayList<String> list) 给递归方法传这些对象，是为了每一次递归都使用这些对象

ArrayList<Integer> list1;ArrayList<Integer> list2;
list1和list2不能使用list1==list2,应该使用list1.equals(list2)

ArrayList<TreeNode> list1;ArrayList<TreeNode> list2;
这两个list保存的node即使val一样,lef,right一样，但还是!list.equals(list2),因为两者的node都不是同一个对象，而使用的是ArrayList的equals()

for(int i = queue.size(); i > 0; i--) {//完美避开队列的size改变
    queue.poll();
for(int i = 0; i < queue.size(); i++) {//每一次poll()，size会-1
    queue.poll();


res.add(new ArrayList<Integer>(list));   而不是res.add(list)

Set<String> output=new HashSet<String>();
return new ArrayList<String>(output); 所有Collection子类型都有一个接收另一个Collection对象的接口，把该对象的元素填充进去


条件12和21的话，对数字的位置有要求
for(int a = 1; a < 10; a++) {
	for(int b = 1; b < 10; b++) {
两数相加对数字的位置没要求，不能同一个相加
for(int i = 1; i < 9; i++) {
	for(int j = i+1; j < 10; j++) {

if(staple[i]+drinks[i]<=x)
i和j经常写错

public void dfs(TreeNode root){     把每一个dfs递归看成一个整体
        if(root==null) return;
        dfs(root.right);     处理右子树
        k--;                      处理root节点
        if(k==0) result=root.val; 处理root节点
        dfs(root.left);      处理左子树
}

error:  while(i<s.length()&&ch=charAt(i++)>='0'&&ch<='9')           ch=charAt(i++)需要加()
true:   while(i<s.length()&&(ch=charAt(i++))>='0'&&ch<='9')

不要急于对两个指针同时操作
while(headA!=headB){
        headA=headA.next;
        headB=headB.next;
        if(headA==null) headA=hB;
        if(headB==null) headB=hA;
}
一个个分开单独操作可以避免许多出奇的测试用例错误
while(headA!=headB){
        if(headA!=null) headA=headA.next;
        else headA=hB;
        if(headB!=null) headB=headB.next;
        else headB=hA;
}

有没有{}，执行效果是不一样的，第二段代码是if语句后break,第一段都是在if中
if(ans%k==0){
    flag=true;
    break;
}
if(ans%k==0) flag=true;break;

public void dfs(TreeNode root,int sum,int targetSum){//递归让某个值保持不变或保存上一次的值，继续传递下去的方法

while时判断if与else



while(root!=null){
          if(root.val>p.val&&root.val>q.val) root=root.left;
          else if(root.val<p.val&&root.val<q.val) root=root.right;
          else break;
}                     //if、if、else和if、else if、break区别很大，后者是整体的
while(root!=null){
          if(root.val>p.val&&root.val>q.val) root=root.left;
		  
          if(root.val<p.val&&root.val<q.val) root=root.right;
          else break;
}

//二分查找可以查找山脉数组的山顶,while退出是left>right时
      int left=1,right=arr.length-2;
      int ans=-1;
      while(left<=right){
        int mid=left+(right-left)/2;
        if(arr[mid]>arr[mid+1]){
          ans=mid;
          right=mid-1;//
        }else{
          left=mid+1;//
        }
      }
      return ans;

if(ch[i]=='.'){
  ch[i]='[.]';  //char类型只包含一个字符,[.]是三个字符
}

表达式的开头非法illegal start of expression，可能是()写成了())

dfs(int i,ArrayList<Integer> list)
递归传递的list，使用list.clear()是对自身的clear(),可以让递归继续传递list
list=new ArrayList<>()不会继续传递list,而是递归另一个地址的list

递归传递一个数组或集合，目的是让该递归持续修改同一个数组或集合;而把数组或集合放在全局上等同于前面提到的递归作用，即使用全局就可以不用使用递归


for(int num:nums){
        for(int i=0,j=res.size();i<j;i++){//res的size会不断变化，需要使用j固定size的值
          List<Integer> list=new ArrayList<Integer>(res.get(i));
          list.add(num);
          res.add(list);                  //res的size会不断变化
        }
}

子集与子集包含的元素的位置无关，与位置有关的是两数组成自然数



//递归结束后是返回到前一个递归，不是返回到第一个递归
如果一个递归后面的语句会影响到该递归传递的参数，那该递归就必须取快照，不然返回后，保存的值会被后面的语句修改
public void dfs(int cur,int n,int k,List<Integer> list){
      if(list.size()==k){
        res.add(new ArrayList(list));//取快照，不然本递归的list会前一个递归的list.remove()影响
        return;
      }
      list.add(cur);                 //list:1
      dfs(cur+1,n,k,list);           //list:1、2        //可以把该dfs()看成一个普通方法，该方法修改了list的值，则下面的list也是保存修改后的list的地址
      list.remove(list.size()-1);//返回后，该list保存为前一个dfs操作list后的list的地址         //此时的list也是1、2       
      dfs(cur+1,n,k,list);
}

if((ans.get(k+1)-ans.get(k))!=differ);         //if后面写了;会导致return不会被if包含
          return false;

一个位置固定只有两种选择，可以使用递归，每一次循环各选择一种
ch[num]='(';
help(ch,num+1,list);
ch[num]=')';
help(ch,num+1,list);
	
int[][] res=new int[3][3];
for(int i:res[2])       //可以取出二维数组res的第三行所有的数据


dfs后面有dfs，且第一个dfs让传递的元素内存空间改变，就必须回溯；而dfs后面有dfs的情况还可以是一个for循环包含dfs
list.add(candidates[index]);
dfs(list,candidates,target-candidates[index],index);
list.remove(list.size()-1);
dfs(list,candidates,target,index+1);


求所有可能性结果，一般dfs即可解决问题

一次递归让栈空间的使用层数加1             而广度优先搜索每一层的所有节点在同一个主递归处理，每一层节点使用栈空间一层
如果深度优先搜索没有使用存储空间，则空间复杂度为树的高度==递归时使用的栈空间大小


//题目所求为删除值为target的节点
//把节点设为null的另一种方法：通过递归把值为target的节点设置为空，而该节点的父节点获取到的该节点就为null
//先左右子树，再根节点，从下到上的思想
public TreeNode removeLeafNodes(TreeNode root, int target) {
      if(root==null) return null;
      TreeNode left=removeLeafNodes(root.left,target);        //不使用方法改变参数内存空间，而可以使用递归返回节点，返回null
      TreeNode right=removeLeafNodes(root.right,target);
      root.left=left;
      root.right=right;
      if(root.left==null&&root.right==null&&root.val==target) return null;     //
      return root;
}

-----------------------------
int count=0;
public int findCount(TreeNode root){         //找出二叉树有多少个节点      区别:父节点、左子节点、右子树节点    遍历所有节点
      if(root==null)
        return 0;
      count++;
      findCount(root.left);
      findCount(root.right);
      return count;
}
public int countNodes(TreeNode root) {       //找出二叉树有多少个节点 
    if (root == null)
        return 0;
    return countNodes(root.left) + countNodes(root.right) + 1;
}

private int countLevel(TreeNode root){       //求二叉树的层数   
        if(root == null){
            return 0;
        }
        return Math.max(countLevel(root.left),countLevel(root.right)) + 1;
}
public int findHight(TreeNode root) {        //求二叉树的层数               区别:父节点、左子树、右子树                 

  if (root == null) 
     return 0;
  int left = findHight(root.left);
  int right = findHight(root.right);
  if (left > right){
      return left + 1;
  }else {
      return right + 1;           //到达叶子节点会返回1
  }

}







解决特殊问题
熟悉数据结构

# 算法方法

## 图:

有向图：入度=有多少条边指向该节点、入度不为0的节点都可以通过入度为0的节点到达

无向图：每一个节点都有邻居节点，使用List<>存储，且作为节点属性

-----------------------------
## 快慢双指针:

可以使用快慢指针来求链表的中位数：
ListNode mid=getMidNode(left,null)  //left为链表头节点
public ListNode getMidNode(ListNode left,ListNode right){
      ListNode fast=left;
      ListNode slow=left;
      while(fast!=right&&fast.next!=right){//使中位数不会到达最右节点，但中位数可以是最左节点
        fast=fast.next;
        fast=fast.next;
        slow=slow.next;                    //链表个数为奇数，fast会到达right,偶数fast会到达right-1
      }
      return slow;
}

求链表倒数第n个节点：
让快指针先走n-1步

-----------------------------
## 摩尔投票法：

核心理念为票数正负抵消

-----------------------------
## 前缀和： 

计算某个下标之前的所有元素的和

-----------------------------
## 子集：

创建一个空集合添加到结果集合里
每到下一个元素，就在已有的所有子集的基础上，再加上该元素

-----------------------------
## 组合：

选择跳过或不跳过该元素

if(count == 2){            //添加组合在判断是否越界之前             
    if(str.equals(target)) ret ++;
    return;
}
if(index >= nums.length || index<0) return;

-----------------------------
## 全排列：

把集合的每个元素作为排列第0个，接下来以除了该元素的集合作为基础，拿出每个元素作为排列第2个


-----------------------------
## 深度优先算法：

从下往上：先左右子树后root
从上往下：先root后左右子树




按每个节点遍历


-----------------------------
## 广度优先算法:

使用Queue按层遍历
使用queue.size()、for循环处理每一层节点          //深度优先搜索不用DFS

```java
while(!queue.isEmpty()){ 
          int size=queue.size();
          for(int i=0;i<size;i++){  
            Node node=queue.poll(); 
            if(i<size-1)
               node.next=queue.peek();//填充
            if(node.left!=null)
               queue.offer(node.left);
            if(node.right!=null)
               queue.offer(node.right);
          }
}
```



-----------------------------
## 动态规划：

把大问题分解成若干个子问题，每个子问题的解都是问题的解
实现方式：递归、非递归

fbi斐波那契
dp数组：使用动态规划的数组

-----------------------------
## 中序遍历+前序遍历：

使用前序遍历下标建立节点   或 
中序遍历+后序遍历：使用后序遍历下标建立节点
使用hashmap保存中序遍历的节点值和当前节点的下标，可通过map.get找到当前节点的右节点和左节点，方便建树

for(int i=0;i<len;i++)
    map.put(inorder[i],i);

使用int postorder_index//后序遍历下标;dfs(int l,int r)建立树时，可通过数组postorder[postorder_index]得到根节点，建立完根节点，后序遍历下标-1，再建立右子树，左子树
右子树就又是dfs(map.get(根节点)+1,r)
其中if(l>r) return null;l、r约束树在数组的范围，也起到结束递归的作用

-----------------------------
## 二分查找：

```java
while(start<=end)    int mid=start+(end-start)/2;
```



-----------------------------
## 分治算法：

求1~n的二叉搜索树的所有可能，根节点值为i，则左子树范围为1~i-1，右子树范围为i+1~n

```java
for(int i=start;i<=end;i++){
        List<TreeNode> leftList=myGenerateTrees(start,i-1);//利用二叉搜索树的性质，root为i，则左子节点范围在i-1以左
        List<TreeNode> rightList=myGenerateTrees(i+1,end);//同上
        for(TreeNode left:leftList){
           for(TreeNode right:rightList){
             TreeNode root=new TreeNode(i);//关键点，当前i的节点
             root.left=left;
             root.right=right;
             ret.add(root);  
           }
        }
}
```



-----------------------------
## 环问题：

使用取余%，得到超出一圈以后，所应该在圈内的下标
while(n>1){
        index=(index+k-1)%n;
        list.remove(index);
        n--;//n需要--,因为圈内的个数在不断减少
}

-----------------------------
## 螺旋矩阵：

按照顺时针螺旋的顺序遍历矩阵所有元素

按照从左到右、从上到下、从右到左、从下到上遍历，使用while(true)循环当所有方格被遍历时退出循环，
其中int l=0,r=matrix[0].length-1,t=0,b=matrix.length-1作为矩阵左、右、上、下边界
每遍历完最顶行则t++，该行不再使用、每遍历完最右列、每遍历最底行、每遍历最左列

改变遍历方向：

### 第一种：在原矩阵里螺旋         

//for循环结束后就改变方向，下标移动来源于下标值与i相加，而i的不断增大

for(int i=l;i<=r;i++){
          list.add(matrix[t][i]);
          if(list.size()>=sum) return list;
}

### 第二种：可在矩阵外螺旋        

//到达边界值就改变方向，下标移动来源于下标值不断，与移动辅助数组相加
int dir=0;//方向指标，0为向右，1为向下，2为向左，3为向上
int[][] assist = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};//移动辅助数组：从左到右，从右到下，从下到左，从左到上if(x >= 0 && x < rows && y >= 0 && y < cols){//如果在原矩阵上则添加
          ret[num][0] = x;
          ret[num][1] = y;
          num++;
}
if(dir == 0 && y == Right){//到达右边界
          Right++;
          dir++;
}
else if(dir == 1 && x == Down){//到达下边界
          Down++;
          dir++;
}
else if(dir == 2 && y == Left){//到达左边界
          Left--;
          dir++;
}
else if(dir == 3 && x == Upper){//到达上边界
          Upper--;
          dir = 0;
}
//当前下标位置，x、y在不断变化，而dir只在上面的if中变化
x += assist[dir][0];

y += assist[dir][1];

## 贪心算法：

每次选最好的

-----------------------------
## 二维数组矩阵：

### 取点到点最短路径

每个下标进行累加，使终点的下标值为最短路径和

### 是否存在值

[240. 搜索二维矩阵 II - 力扣（LeetCode） (leetcode-cn.com)](https://leetcode-cn.com/problems/search-a-2d-matrix-ii/)

取右上角下标值，下标不断下移、左移直到找到所求

-----------------------------
## 字符串题目：

```java
//该方法可以巧妙地求字母在字符串中出现的最后一次的位置，涉及到覆盖
String str="hklfjgjhfjha"
int res=new int[26]
for(int i=0;i<str.length();i++)
     res[s.charAt(i)-'a']=i;                    //字符串为大写就为-'A' 


//该方法也计算每一个字母出现的次数，并使相同字母都在数组的同一位置
String str="hklfjgjhfjha"
int[] res=new int[26];
for(int i=0;i<tiles.length();i++)
    ++res[tiles.charAt(i)-'a'];                 //字符串为大写就为-'A'

//该方法可以巧妙地根据整型数组新建字符串
for(char i='a';i<='z';i++){
        for(int j=0;j<word[i-'a'];j++)
           sb.append(i);
}
```



-----------------------------
## 还原数组：

找到新数组的第一个值


-----------------------------
## 括号匹配：

HashMap

-----------------------------
## 字符串数字运算：

递归保存上一层循环两个数字运算的值，方便下一层循环对乘法除法的处理

# 程序输入输出

牛客网:
使用Scanner sc=new Scanner(System.in),while(sc.hasNext() System.out.println())会使程序永恒地执行下去，而且一次输入后就会输出一次结果而不是全部输入后统一输出结果
import java.io.*;
import java.util.*;

牛客网推荐使用：BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));Scanner容易报错
bf.readLine();

String[] str=bf.split(" ");根据字符串空格拆分成一个String数组

int i=Integer.valueOf(str);int i=Integer.parseInt(str)将字符串转换为整数     Long.valueOf()   
char c='3';int b=c-'0';将字符转换为整数
String str=String.valueOf(char[] data);将char数组转换成字符串
String num=1+"";
String str='c'+"";
char c=(char)1;             将整数转换成字符

牛客网的输入回车结束：if(bf==null||bf.equals("")) break;


char a='A';
System.out.println(Integer.valueOf(a));    //Integer.valueOf()可以把字符转换为ASCII码
'A'为65；'Z'为90；

'a'为97；'z'为122；

nextInt()和nextLine():
while(sc.hasNext())相当于while(true)
输入一个数代表可以sc多少个数或行才可停止输入

int n=sc.nextInt();
sc.nextLine();//读取nextInt()后产生的换行符
String line=sc.nextLine()

前面是sc.nextInt(),nextLine()才会读到换行符，而前面如果是nextLine()，则下面的nextLine()不会读到换行符，因为第一行line把"\n"读取了,而nextInt()不会读取"\n"
while (!(line=in.nextLine()).equals("")) {      //不输入任何，按回车读到的是空格
}

sc.nextInt()产生的所谓的换行符其实是一个"",也可能"\n"不能显示出来

--------------------------------------------------------------------------------------------
# java方法

ans是一个答案存储器
dist 长度
数组 res （resource资源)
辅助指针 前一个pre 当前cur next
动态规划dp数组

Math.min()
Math.sqrt() 平方根
Math.abs() 取绝对值
Math.ceil()  返回数字的上舍double整数
Math.floor() 返回数字的下舍double整数   -6.1》-7.0    101.6》101.0
Math.pow(a,b) 幂
Math.exp()
Math.log()
str.charAt(1)     charAt()只是返回str的某个字符，不能str.charAt(i)='6'
str.indexOf('a')
Arrays.sort()给数组排序  给list排序Collections.sort()从小到大
Arrays.fill(int[] res,int i)把res的所有值都赋值为i
把str转换为int,int tem2=Integer.parseInt(s);
将数组转换成字符串    System.out.println(arr)输出的是数组的地址;
                      System.out.println(Arrays.toString(arr))将数组内容输出,不是转换成字符串;           //只对一维数组有效，不可输出二维数组
					  char[] ch=new char[n];System.out.println(new String(ch))将char数组转换成字符串,也可以System.out.println(String.valueOf(ch));
String str=new String(arr,0,arr.length);
将字符串转换成数组
str.toCharArray()
str.valueOf()找位置     str.charAt(index)找字符
把list转换为数组
ArrayList<String> list=new ArrayList<String>();
String[] strings = new String[list.size()];
list.toArray(strings);
将char数组转换成字符串 String.valueOf(char[] data)  











--------------------------------------------------------------------------------------------
# 二叉树

二叉排序树又称二叉搜索树，根结点的值大于左子树所有的值，根结点的值小于右子树所有的值
平衡二叉树AVL Tree：任意节点的左右子树的高度差不大于1
广度优先算法BFS  二叉树从上到下按层次遍历
class BinaryTreeNode {
	int val;
	BinaryTreeNode left;
	BinaryTreeNode right;

	public BinaryTreeNode(int val) {//构造方法，给这个类对象赋值
		this.val=val;
	}
	            public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}等setter、getter方法
}

BinaryTreeNode test=root.right;则代表root.right全部都赋给了test整个对象赋值),而如果root.right.setVal()则test的val也会变,test.setVal(),root.right的val也一样变,
因为他们都是指向同一个地址
而如果root.right=root.left,则root.right与test从此无关
(本质就是对象引用test和root.right都指向堆里同一个地址，而root.right=root.left后root.right的地址指向已经改变)

二叉树的层数=高度
二叉树的深度==左右子树最长的边数+1==层数
带权路径长度WPL=边*权      WPL最小为赫夫曼树
赫夫曼树的保存权的节点必须是叶子节点




--------------------------------------------------------------------------------------------
# 链表

class ListNode{
    int val;
    ListNode next=null;
    //加数据
    ListNode(int val){//构造方法，给这个类对象赋值
	this.val=val;
	}
}
ListNode :给链表加数据 ListNode node=new ListNode(1)；node.next=new ListNode(2);
class ListNode {
    int value;
    ListNode next;
}
        ListNode node1 = new ListNode();
        ListNode node2 = new ListNode();
        ListNode node3 = new ListNode();
        node1.value = 1;
        node2.value = 2;
        node3.value = 3;
        node1.next = node2;
        node2.next = node3;
        node3.next = null;

把head赋值给node的下一个： node.next=head      node的下一个赋值给head:  head=node.next

ListNode cur=new ListNode(0);ListNode pre=cur;则给cur后面next多少个，也代表pre后面也next多少个
因为pre=cur代表cur的所有都赋给了pre(整个对象赋值),而如果后来cur=cur.next,但pre还是那个pre,此时pre和cur没有一点关系






--------------------------------------------------------------------------------------------
# 集合

散列表 使用散列表HashSet来存储字符，Set<Character> occ=new HashSet<Character>();   添加:occ.add()   删除:occ.remove()  是否包含:occ.contains( )，该方法返回boolean值

使用哈希表HashMap来存储对应的键值对
Map<Character, Character> map = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
方法  map.containsKey()  map.containsValue()  返回ture false      map.get()  map.put()

使用HashMap来存储数组中每个数字出现的次数
Map <Integer, Integer> map = new HashMap();
for (int n: nums) {
     map.put(n, map.getOrDefault(n, 0) + 1);
}
for(int key:map.keySet()){             //根据value获取相应的key
    if(map.get(i)==1) arr[index++]=key;
}

mp.values()
mp.keySet()
mp.entrySet()    返回此映射所包含的映射关系的 Set 视图
获取在map中元素个数为1的元素
for(Map.Entry<Integer,Integer> ep:map.entrySet()){       for(char c:map1.keySet())
            int as=ep.getKey();
            int occ=ep.getValue();
            if(occ==1){
                ans=as;
                break;
            }
        }



栈
栈的两种实现方式：Stack时间消耗更少 Deque<Integer> myStack = new LinkedList<Integer>(); LinkedList<Integer> objects = new LinkedList<Integer>(); Stack<Integer> myStack=new Stack<Integer>()  
入栈myStack.push(node)   出栈myStack.pop()    stack.size()    stack.isEmpty()，不能写为stack==null
stack.peek 与 stack.pop 的区别 相同点：大家都返回栈顶的值 不同点：peek 不改变栈的值(不删除栈顶的值)，pop会把栈顶的值删除。
堆 Queue<Integer> qe=new PriorityQueue<Integer>()；左父右子
最大堆 自动排序 PriorityQueue<Integer> pq = new PriorityQueue<Integer>()   插入 pq.offer()   移除 pq.poll()






队列
Queue<TreeNode> queue=new LinkedList<TreeNode>();
出队列 queue.poll()     queue.isEmpty()    queue.size()    queue.add()








Colleacions集合
Colleacions.swap(List<?> list, int i, int j)在指定列表的指定位置处交换元素
Colleacions.disjoint()如果两个指定 collection 中没有相同的元素，则返回 true

Colleacions.retainAll(Colleacions<?extends>)    让第一个Collections只保留他们的交集元素

Collections.sort(List<T>,new Comparator<T>())给List<String>排序,重写Comparator的compare方法
Collections.sort(rec, new Comparator<String>() {
            public int compare(String word1, String word2) {
                return cnt.get(word1) == cnt.get(word2) ? word1.compareTo(word2) : cnt.get(word2) - cnt.get(word1);
            }
        });
compareTo方法：Integer x = 5;System.out.println(x.compareTo(3));如果指定的数与参数相等返回0；如果指定的数x小于参数返回 -1；如果指定的数大于参数返回 1
compareTo比较字符串的话，是根据字符串的字典序





--------------------------------------------------------------------------------------------
# List与数组

String数组： String[] str=line.split(" ");
int []A= {0,1,2,2,3,3,6} 和 public static int out(int[] arr)
int[] arr=Arrays.copyofRange(int[] arr,int l,int r);

行长度arr.length   列长度arr[0].length
一维数组：int arr[3]={1,2,3};一个长度为3的一维数组
二维数组：int arr[2][3] ={{1,2,3},{1,2,3}};两个长度为3的一维数组              int arr[3][2]={{1,1},{2,2},{3,3}}，把一维数组的每个值变成了2个值


三维数组:
int[][] arr2=new int[2][3]{{1,0,1},{1,0,1}};
[
   [1,0,1],   
   [1,0,1]
]
int[][] arr3=new int[2][3][2];   //三维数组相当于把二维数组的每个值变成了n个值    //1对应[true,false]
[
   [[true,false],[false,false],[true,false]],
   [[true,false],[false,false],[true,false]],
]




数组的引用变量的内存地址保存在栈，而内存空间是保存在堆里的一连串相连在一起的单个内存空间


ArrayList: 可以看作是能够自动增长容量的数组
LinkList是一个双链表,在添加和删除元素时具有比ArrayList更好的性能.但在get与set方面弱于ArrayList.
创建一个可以存储数组的数组 List<List<Integer>> res=new ArrayList<>();   res.add()   res.get(index)  res.size() 不可以.length()
添加:res.add(new ArrayList<Integer>(Arrays.asList(1,2,3)));
创建一个可以存储Boolean的数组 List<Boolean> list=new ArrayList<>();
list.add(true);
ArrayList :动态数组,可以动态地增加或减少元素
Arrays.asList()  把数组转换为List
list.add(Index i，Element e)，添加元素时，若索引位置没有值，则直接添加，若索引位置有值，则添加到索引位置，后边的元素依次往后移动。
return list.subList(0,k)   返回list第0到k-1个数

List是固定大小的数组
Arrays.asList()生成的List,是固定大小的数组，修改它的大小会抛出UnsupportOperationException
List<String> list = Arrays.asList("A B C D E F G H I J K L".split(" "));
List<String>  subList = list.subList(0,2);
try { list.retainAll(subList); } catch(Exception e) {
     System.out.println("retainAll(): " + e);
}

Colleacions.retainAll(Colleacions<?>) //让Collections只保存Colleacions<?>中的元素









LinkedList:双链表，可以向头部或者尾部插入数据
LinkedList<Integer> link = new LinkedList<>();
link.addFirst()     link.addLast()







--------------------------------------------------------------------------------------------
# String类型

字符串拼接
String first="hello";
String second="world";
String word=first+","+second
String拼接字符串会创建一个新的对象

StringBuilder sb=new StringBuilder("hello");
String second="world";
String word=sb.append(",").append(second)

StringBuffer数组
StringBuffer[] sb=new StringBuffer[6];
sb[0]=new StringBuffer();
sb[0].append("hello")

StringBuilder方法    sb.toString()   sb.append()

使用方法对String a进行改变，a不变，因为字符串是不可变的，String是final型；而如果不使用方法，直接a="123",则a可以改变

str.substring(0,3)  保留的是从0到2位置的字符串  "hamburger".substring(4, 7) returns "urg"   "smiles".substring(1, 5) returns "mile"
str.substring( )     "Harbison".substring(3) returns "bison"

trim()去除字符串前后的" "    str.split(" ")按" "分割字符串

字符串引用在栈，实际数据在堆，常量池在堆里面
String s1="abc";
String s2="abc";
System.out.println(s1==s2);//true   因为在编译String s2="abc"的时候常量池中已经有了"abc"的地址值,所以让s2直接指向常量池中的"abc"，这样s1和s2的地址值都是常量池中"abc"的地址值
System.out.println(s1+s2=="abcabc");//false    在字符串的+操作中，只要有一个为字符串引用，因为引用值编译期无法确定值，故是在运行期动态运算后赋予新的地址，而这个新的地址是该常量池对象的拷贝对象，地址不同故false
System.out.println(s1+"abc"=="abcabc");//false   //s1+"abc"对象和"abcabc"对象不是同一个内存地址空间
System.out.println(s1=="ab"+"c");//true        两个无引用的字符串的拼接在常量池操作，因为常量池相同内容的都是同一个对象，给内容相同则地址一定相同
System.out.println("abc"+"abc"=="abcabc");//true

栈：存放基本类型的数据和对象的引用
堆：存放new出来的对象，注意创建出来的对象只包含各自的成员变量，不包括成员方法
常量池：存放常量，如基本类型的包装类(Integer、Short)和String,注意常量池位于堆中

编译期创建好的String s1="abc",会存放在常量池，s1此时是常量池的一个对象;
运行期new出来的String str=new String("abc")存放在堆，jvm会先查看常量池有没有"abc"这个对象，如果没有就在常量池创建该对象，并在堆中创建该常量池对象的拷贝对象

//aa和bb是两个不同的对象，{1,2}是保存在堆的，此时堆里有两块{1,2}
int[] aa={1,2};
int[] bb={1,2};
System.out.println(aa.equals(bb));//false Object的eqlals(),比较的是数组对象是否同一地址

char[] ch1={'a','b'};
char[] ch2={'a','b'};
System.out.println(ch1.equals(ch2));//false Object的eqlals(),比较的是数组对象是否同一地址
System.out.println(Arrays.equals(ch1,ch2));//true Arrays的eqlals(),比较数组的每个值是否相同
System.out.println(new String(ch1).equals(new String(ch2)));true  String的eqlals(),比较char数组的每个值是否相同
System.out.println(new String(ch1)==new String(ch2));false

ArrayList<Integer> list1 = new ArrayList<Integer>(Arrays.asList(1,2,3));
ArrayList<Integer> list2 = new ArrayList<Integer>(Arrays.asList(1,2,3));
System.out.println(list1.equals(list2));//true 
ArrayList的equals(),拿出ArrayList的每个元素，把每个元素分别进行equals(),如果是Integer则使用Integer的equals()他们值相当就true,如果是node对象，则使用Object的equals()

sum(1,2)           //1、2是实参                     sum(int a,int b)          //a、b是形参

关于字符串作为方法参数：
class Node{
    int val;
    public Node(int val){
        this.val=val;
    }
    public String toString(){
        return val+"";
    }
    public void setVal(int val){
        this.val=val;
    }
}
public class Test {
    public static void main(String[] args) {
        Nodde node1 = new Node(2);                               //栈分配变量的内存地址，堆开辟内存空间，如果变量有值则它保存了内存空间地址
        replace(node1);                                         //int a=1;a有栈的内存地址，还保存了堆的数据为1的内存空间地址
        System.out.println(nodde);                              //java所有的参数传递的都是原变量的副本，能否改变原变量的数据，要看该方法能否改变原变量的内存空间地址所对应的内存空间，下面同
    }                                                           //int a=1;replace(int a)值传递，该形参a是基本数据类型a的复制，两者内存地址不一样,但保存的的内存空间地址一样都是1的地址
    public static void replace(Nodde ans){                     //引用传递，该实参ans是node1的复制，两者内存地址不一样,但保存的内存空间地址和node1一样
        Nodde node2 = new Node(1);                   //无论是值传递还有引用传递，要改变该形参的内存空间地址所对应的内存空间，才可以真正改变该原变量   //而node=node2;没有改变node1的内存空间地址所对应的内存空间，只是把形参node指向node2的地址
        ans=node2;                                   //基本数据类型的内存空间地址和内存空间绑定不可改变，String类型的内存空间地址和内存空间绑定不可改变，因为常量池同一份内容只对应一份地址,所以基本数据类型、String类型都无法做到在不改变原变量内存空间地址的情况下，改变该内存空间，所以都无法改变原变量
    }                                                //基本数据类型为值传递，String类型表现为值传递
}
public class Test {
    public static void main(String[] args) {
        Nodde node1 = new Node(2);
        replace(node1);             
        System.out.println(nodde);
    }
    public static void replace(Nodde ans){
        ans.setVal(1);                                    //该方法改变了node内存空间地址保存的数据，故原数据node1的值也改变
    }
}



















--------------------------------------------------------------------------------------------
# 继承：

extends的步骤
// 1. 初始化父类中的静态成员变量和静态代码块 ；  
// 2. 初始化子类中的静态成员变量和静态代码块 ；  
// 3. 初始化父类的普通成员变量和代码块，再执行父类的构造方法；     //父类的方法不会被初始化
// 4. 初始化子类的普通成员变量和代码块，再执行子类的构造方法；  
静态代码块只会执行一次，而非静态代码块会在多次创建对象时多次执行
B extends A         A ab=new B()可以使用父类所有的方法和子类覆盖的方法，不能使用子类特有的方法，和B ab=new B() 的执行效果不一样

super.调用父类的方法  
class Base
{
    public void methodOne()
    {
        System.out.print("A");
        methodTwo();   //此时methodTwo()调用的不是父类的methodTwo(),而是子类的methodTwo()
    }
	public void methodTwo()
    {
        System.out.print("B");
    }
}
class  Derived extends Base{
    public void methodOne()
    {
        super.methodOne();
        System.out.print("C");
    }
    public void methodTwo()
    {
        System.out.print("D");
    }
}
Derived d=new Derived();d.methodOne();
父类中两个被子类重写的方法，如果在父类方法里调用父类的方法，默认都是调用子类的方法

继承的时候你要记得子类一定会调用父类的构造方法，如果没有显示的调用则系统默认调用父类参数为空的构造方法，而且若要用super调用父类的构造方法必须写在方法的第一行  

子类是个普通类，父类方法为抽象方法，必须重写所有父类的抽象方法；而如果父类为普通方法,可以重写也可以不重写
如果子类是个普通类，那么必须实现这个接口/抽象类的所有抽象方法；如果子类是个抽象类，那么不必实现这个接口/抽象类的抽象方法，因为抽象类中可以定义抽象方法

继承重写，接口实现

class Derived extends Base {
    public void methodOne() {
        super.methodOne();        //在子类的方法上可以super,其他地方不可
        System.out.print("C");
    }
    public void methodTwo() {
        
        System.out.print("D");
    }
}


class A{
    public void a(){
        System.out.println("666");
    }
    public A(){
        System.out.println("a");
    }
}
class B extends A{
    public void b(){
        a();                      //子类的方法上可以调用父类的方法,其他地方不可
    }
    public B(){
        System.out.println("b");
    }
}


B extends A, 没有左父右子的情况下,A a=new A();a.aaa();调用的是父类的方法，与子类无关，不会调用子类的aaa方法
class A{
    static{ System.out.print("A"); }
    public void aaa(){
        System.out.println("aaa");
    }
    public A(){
        System.out.print("a");
    }
}
class B extends A{
    static{ System.out.print("B"); }
    public void aaa(){
        System.out.println("bbb");
    }
    public B(){
        System.out.print("b");
    }
}


A ab=new B();ab.b();        左父右子，无法使用子类B特有的b(),只有B b=new B(),b.b()才可
class A{
    public void a(){
        System.out.println("666");
    }
    public A(){
        System.out.println("a");
    }
}
class B extends A{
    public void b(){
        a();                    
    }
    public B(){
        System.out.println("b");
    }
}
向上转型的好处藏在extens里，而不是在实例化的语句里，B ab= new B()和A ab=new B()只有A ab=new B()不能使用B类特有方法的区别

向上转型：可以使用子类父类共有的方法，也可使用父类特有的方法，不可使用子类特有的方法
//无论有没有向上转型，子类都可以使用父类特有的属性
B b = new B();
b.test();
class A{
    int a=1;
    private native int read0() throws IOException;//装饰的丰富
}
class B extends A{
    public void test(){
        System.out.println(a);
    }
}
//无论有没有向上转型，子类都可以使用父类特有的方法
B b = new B();
b.test();
class A{
    public void test(){
        System.out.println(a);
    }
}
class B extends A{
    
}

new子类实例更好，该实例就拥有了子类所有的方法，包括拥有子类以上的所有方法
子类的某个父类继承了某个类，则子类实例也可以使用该类的方法

a接口继承了b接口，那a接口的实现类必须都实现a、b的方法





public class Test {
    private void a(){};
	static void b()}
}
class te extends Test{
    public void c(){
        a();         //子类可以使用父类的static方法，但子类不可调用父类的private方法
        b();
	}
}









--------------------------------------------------------------------------------------------
# static与final：

static变量只能是类变量，不能放在方法里面
static修饰的类变量是属于类的，可以直接获得，没有static修饰的类变量得通过对象获得
public class AccessProperty {
	static int i = 6; // 定义静态类成员变量
类变量使用static修饰，该变量无论对象实例多少次，都是指向同一个内存，所以修改它，全局的i都会变化
而且i变量值不随函数执行结束而消失，下次调用同一函数时，上次所赋予的值仍存在

static修饰的方法是属于类的，不属于对象
静态方法只能继承,不能重写,所以子类不能覆盖父类的static方法
静态方法中不能用this和super关键字,static修饰的方法只能访问所属类的静态成员变量和静态成员方法


final不能修饰接口，也不能修饰抽象接口
当一个类被final所修饰时，表示该类是一个终态类，即不能被继承
当一个方法被final所修饰的时，表示该方法是一个终态方法，即不能被重写
当final修饰一个基本数据类型时，表示该基本数据类型的值与类型不能发生变化 final int a=1;   //final修饰的变量必须使用数值赋值或者构造器赋值
final修饰的变量代表必须是有值的，因此需要被初始化，即在构造方法里给该final变量赋值
如果final修饰一个引用类型时，表示该引用类型不能再指向其他对象


final修饰的属性final int a；第一次赋值后，便不能再赋值了
final只能使用类的构造方法赋值或者private String helpName="123";private final String name=helpName;  set方法无法使用



为什么string是final的：
因为string是使用十分频繁的基本数据类型，所以必须确保它的安全性，而把string类设置为fianl可以防止通过继承string类来修改string的属性和方法，从而确保了string的安全性









--------------------------------------------------------------------------------------------
# Lambda表达式：

->
Lambda表达式作为推动Java8发布的最重要新特性，Lambda表达式允许把函数作为一个方法的参数
(x, y) -> x – y   //接受2个参数(数字),并返回他们的差值  
sort(List<T> list, Comparator<? super T> c)根据指定比较器产生的顺序对指定列表进行排序
Collections.sort(list, (a, b) -> map.get(b) - map.get(a))//根据Map的Value次数从大到小排序         //底层是if(comparator.compare(x,(E) e)>= 0) break;
Collections.sort(list, (a, b) -> map.get(a) - map.get(b))//根据Map的Value次数从小到大排序         //如果覆盖的方法按形参的顺序return a-b即是从小到大，反之


​	
new Thread(()->{                     
​	   try {
​			player.play();
​	   }catch (JavaLayerException e){
​		e.printStackTrace();
​	   }
}).start();                                 //使用Lambda表达式和普通写法      //省略了new Runnable()和public void run()                
new Thread(new Runnable(){
​    public void run(){
​	   try {
​			player.play();
​	   }catch (JavaLayerException e){
​		e.printStackTrace();
​	   }
​	}
}).start();


public class Test{
    public static Player player = null;                 //因为musicThread类是静态的,musicThread类想要获取player,player必须是静态的的
    public static void main(String[] args) throws IOException, InterruptedException, JavaLayerException {
        //声明一个File对象
        File file = new File("E:\\offer\\SuperRobot\\src\\main\\java\\res\\music\\");
        File[] files = file.listFiles();
        Random random = new Random();
        int index=random.nextInt(files.length - 1);
        File mp3 = files[index];
        //创建一个输入流
        FileInputStream fileInputStream = new FileInputStream(mp3);
        //创建一个缓冲流
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        //创建播放器对象，把文件的缓冲流传入进去
        player = new Player(bufferedInputStream);
    }
    public static class musicThread extends Thread{                        //
        @Override
        public void run() {
            try {
                player.play();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}

虚线是实现接口，实线是继承

Colleacions<?>        //?是在作为参数时泛型的写法，在类定义上才写T、K、V

foreach和for的效率差不多，在其他情况上会有差异
可以使用foreach是该类实现了iterable接口
ArrayList<Integer> list = new ArrayList<>();
list.add(1);
list.add(2);
//使用foreach不能remove/add元素，因为modCount和expectedModCount不相等，会throw new ConcurrentModificationException();
for(int i:list){
    if(i==1){
      list.remove(0);
    }
}



//lambda遍历集合
ArrayList<Integer> list = new ArrayList<Integer>(){{add(1);add(2);add(3);}};
        for(int i:list){
            System.out.println(i);
        }
        list.forEach(i->{                          //有条件判断需要加{}
            if(i==1){System.out.println("hhhhhhhh");}
        });






--------------------------------------------------------------------------------------------
# 接口类与抽象类：

接口只能extends接口


类不能多继承类，接口可以多继承接口类  
interface People {
 default void eat(){
  System.out.println("人吃饭");
 }
}
interface Man {
 default void eat(){
  System.out.println("男人吃饭");
 }
}
interface Boy extends Man, People {
 @Override
 default void eat() {                        //但必须重写父类的方法，不然编译器不知覆盖哪个父类的eat()
  System.out.println("男孩吃饭");
 }
}



//继承类或接口类都一样，一个接着继承一个的话，子类.父类方法,该方法使用最接近子类的父类的方法



接口类可以写实现方法，分为接口默认方法，接口静态方法                      //接口类添加了继承类特征,继承类升级版，除了接口特征，其他和继承类一模一样
public interface interfaceTest {      
    void sout();         //接口方法
    default void a(){    //已实现方法            //接口类的实现方法只有两种default或static,为了让该方法可重写、不可重写，抽象类的方法也是只有两种可重写、不可重写，只不过不用特定写default
        System.out.println("khljhl");            //a()和b()的使用和抽象类的继承，向上转型没有区别
    };
    static void b() {    //已实现方法
        System.out.println("111");;
    }
}

左父右子，无法使用子类特有的方法，所以MyDeque<Integer> myStack2 = new MyLinkedList<>()可以规范对象不使用LinkedList特有的方法

抽象类abstract和接口类interface总体没有什么区别
接口和抽象类接口都可以有成员变量
接口和抽象类接口都不能实例化：接口类 is abstract; cannot be instantiated
区别：abstract class A{}、interface AA{},abstract有class
区别：一个普通类只能继承一个abstract类，而一个普通类可以实现多个interface接口
区别：接口不能有构造方法，抽象类可以有构造方法
区别：
接口和抽象类接口只能由public、default修饰；
接口方法只能由public、default、static修饰；抽象方法可以由public、default、protected、privated、static

public interface People {
    void write();}
abstract class Animal implements People{              //抽象类实现一个接口，那该抽象类的子类就必须实现接口的方法
    abstract void eat();
}
public class Cat extends Animal {
    void eat() { System.out.println("cat eat");}
    public void write() { }
}

接口不能继承抽象类，只能继承接口

# 运算符：

1/2=0
0%2=0
9%10=9

1=00000001
2=00000010
3=00000011

1^2^3    相当于     2^1^3    顺序无影响

\\w+      匹配任何有空格或标点符号隔开的字符串
\\w+\\.   匹配任何以.结尾的字符串

“\\.”和“.”同意，全句即根据'.'拆分字符串
String[] str=leftStr[1].split(".")达不到标准的话可以使用String[] str=leftStr[1].split("\\.");

str="1+1i"
String arr[]=str.split("\\+|i");   //把字符串按+和i分割，String arr[]={"1","1"};

.代表当前目录下

.表示任意字符，而$代表字符串末尾

\n换行符、\r回车符，其中System.out.println("hello\rworld")，回车前面有字符会被覆盖掉，输出world

int c=a---b     是a--,不是--b

count+=(n>>>=i)&1不行
则使用如下
if((n&1)==1){
   count++;
};
n=n>>>=1;   //

向右移一位    n>>>=1或n>>=1
递归最后return的是第一层
float a=25/2;double b=25/2;    a=12.0   b=12.0

右移>>                 当num为正数,且没有达到最大值Integer.MAX_VALUE时 相当于除以2^n       空位补0   
左移<<                 当num为正数,相当于乘以2^n                                           正数空位补0，负数空位补1
无符号右移>>>          相当于右移     
java没有无符号左移                       
有其他数字运算的话，右移左移应该写在括号里(b<<a)                                           
(1<<floor-1)+(1<<floor)-1-label;是(1<<floor-1)
1<<(floor-1)+(1<<floor)-1-label;是1乘以右边所有

//
int a=1<<2;
a=a^15;
int b=1<<2^15;         //a和b都是11，先<<后^，其中^是异或运算

答案需要取模取余 1e9+7(1000000007),则把结果sum=(a+b)%1000000007;

输出ASCII码  System.out.println((int)'c');  ==  System.out.println('c'-0);   //''-0固定是求ASCII码
char c='3' c-'0'表示整数3，原理是3的ASCII减去0的ASCII等于c的整数形式
int a='c'-'0';   表示'c'的ASCII码减去'0'的ASCII码

得到多位数的每个数：int temp=num%10   num/=10

−2^31    Integer.MIN_VALUE     2^31-1   Integer.MAX_VALUE

十进制的大小为10^9,因为10^9<2^30,所以十进制10^9的二进制位数为29    可以类比10^1<2^4,10==1010

任何数和0做异或运算，结果仍然是原来的数
任何数和其自身做异或运算，结果是0
异或运算满足交换律和结合律，即a⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b
XOR 异或运算，1和1等于0，1和0等于1，其中0和任何x XOR都等于x       java符号为^      其运算法则是对运算符两侧数的每一个进制位同值则取0，异值则取1

^异或运算
&与运算
~按位非

2的指数幂值，如16=10000，32=100000，他们二进制1的个数都只有1个1
而他们的-1值，5=1111，31=11111，全部都是1
故可以通过n&(n-1)==0判断该n是2的指数幂，n&(n-1)!=0判断该n不是2的指数幂

java的  121/10=12  9%10=9


if(board[row][clo]==1&&liveNum-1<2||board[row][clo]==1&&liveNum-1>3)
可以转换为：
if(board[row][clo]==1&&(liveNum-1<2||liveNum-1>3))

^异或运算    &按位与运算

n += 1;不会改变变量本身的数据类型
而n = n + 1;会改变变量本身的数据类型

取模差不多等于取余




--------------------------------------------------------------------------------------------
# 其他：

每个整数占4个字节

方法不能和类同名

字符串有值类型和引用类型

链表不能直接打印，需要借助ArrayList

没有返回值使用void

一个类的构造方法可以让该类自动new对象，可参考G

Scanner sc=new Scanner(System.in);
int num=sc.nextInt();
int[] arr=new int[num];

Integer.parseInt(): 把()里的内容转换为整数

字符串123456789 
(137)子序列是非连续的，(123)子串是连续的
"回文串”是一个正读和反读都一样的字符串
个位数都是回文数

while(arr[l]==arr[++l])     直到某一个数组值不等于第一个数组值才退出循环
for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(haystack.charAt(i+j)!=needle.charAt(j))  可以使第一个for循环i不变的情况下，使i在第二个循环不断增加和j比较

使用for循环对数组的每个值进行操作，i从1开始   
int[] arr={1,2,3}; 
for(int i:arr){
      arr[i-1]++;
}


public int[] Main(） {      //返回类型是一个int[]
        return new int[]{1,2};
    }



break结束循环，continue继续循环
类可以小写

转换成小写 toLowerCase方法会重新new一个对象

.class文件是字节码文件
类方法可以和类同名
static add(int a,int b){}    其中a、b是形式参数
在主方法main中使用int a=1,b =1;add(a,b)    其中a、b是实际参数
其中a、b是形式参数
把表示范围大的数转换为表示范围小的数，需要强制类型转换


==和equals
基本数据类型：变量的引用和数据存放在栈里；引用数据类型：对象的引用存放在栈里，实际数据(地址)存放在堆里
把表示范围大的数转换为表示范围小的数，需要强制类型转换
标识符不能数字开头  $Usdollars可以
基本数据类型==原生类==内置类型
值传递call by vallue    引用传递call by reference                    基本数据类型作为形参只是值传递，而对象作为实参是引用传递
非静态的类方法属于对象的成员,不是类的成员；而静态方法属于类的成员

由于一个员工最多有一个直系领导，可以有零个或若干个直系下属，因此员工之间的领导和下属关系构成树的结构
先++是先+后执行这行语句；后++是先执行完这行语句再+


Queue<TreeNode> queue=new LinkedList<TreeNode>(){{add(root);}};
相当于   Queue<TreeNode> queue=new LinkedList<TreeNode>(); queue.add(root);

构造方法没有返回值类型，也不能定义为void

public MyArraylist() {
        this(defalut_capacity);//this的作用无参构造方法调用有参构造方法
}
public MyArraylist(int capacity) {
        elements = new int[capacity];
}


Random rand = new Random()；int t=rand.nextInt(10);产生0~9的一个随机数

sout(this) 默认会打印对象本身的地址，而如果对象的方法有重写toString(),则打印的是toString()的内容

没有public的构造函数默认是protect,只对本包开放


排好序的字符串数组是根据字典序排序

if (!(o instanceof List)){//instanceof判断o是否为List的实例
  return false;}

public class Test{
    public static void main(String[] args) {
    }
    public int a(){
        return -1;
    }
    public void b(){
        a();//方法可以调用方法
        System.out.println();
    }
}

public static void main(String[] args){
        int a=1;
        changeInt(a);                       
        System.out.println(a);              //实参和形参共享同一份内存空间地址，但该方法无法改变该内存空间地址的数据，方法传递的参数只是原变量的副本，a=2只是把形参的地址指向2，而原变量还是还是指向1


        int[] arr={1,2};
        changeObject(arr);                  //可以通过方法改变Object对象的值
        for(int aaaa:arr){
            System.out.println(aaaa);
        }
    }
    public static void changeInt(int a){
        a=2;
    }
    public static void changeObject(int[] arr){
        arr[0]=666;
    }

组合数没有顺序之分，排列数有顺序之分

1+""把1变为字符串

Integer.MAX_VALUE是int类型

catch捕获异常后，catch后面的语句还会执行

Node<K,V>[] table;
table=(Node<K,V>[])new Node<?,?>[DEFAULT_INITIAL_CAPACITY];         //new Node<?,?>没有给出明确的类型，需要转型和具有明确类型的引用类型table对应上

public static int maxProfit(int[] prices) {
        if(prices==null) return 1;
        System.out.println(prices.length);
        return 2;
    }
public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{}));            //传递空数组，但数组不为null,而大小为0      故有arr!=null&&arr.length>0
}


int a;
public static void main(String[] args) {
        new Test().a();
}
public void a(){
        System.out.println(a);               //a没有赋值，默认int a为0
}

同一个包的类不用使用import,import是导入其他包的

FIFO指先进先出队列

ASCII码表：1、A、a

Integer.MAX_VALUE是2^31-1



//Arrays.copyRandom(int[],left,right)；复制数组
int[] preorder={8,5,1,7,10,12};
int leftLen=3;
int[] leftArr= Arrays.copyOfRange(preorder,1,leftLen+1);
int[] rightArr=Arrays.copyOfRange(preorder,leftLen+1,preorder.length);
System.out.println(Arrays.toString(leftArr));//[5, 1, 7]
System.out.println(Arrays.toString(rightArr));//[10, 12]

contains而笔试contain

# Typora快捷键

Ctrl+Shift：回车一行
Ctrl+1：一级标题
Ctrl+Shift+K：代码块
理论上不使用一级标题也可以，区别在于字体大小	

# Typora标题问题：

## Old-Method：

英文：1级标题 -> 2级标题(广度流行技术)			
中文：1级标题 -> 3级标题(广度流行技术)			2级标题 -> 4级标题(offer)			4级标题 -> 6级标题(offer)

## New Method：

> 好处：维护时方便统一替换

英文：1级标题 -> 2级标题 -> 3级标题			
中文：1级标题 -> 2级标题 -> 3级标题
中英文混合：同上

# 标题

## 标题

### 标题

#### 标题

##### 标题

###### 标题

# note

## note

### note

#### note

##### note

###### note