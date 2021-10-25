# Thrift: The Missing Guide

From: https://diwakergupta.github.io/thrift-missing-guide/#_translations

内容基于 Thrift 0.6.0

From the [Thrift website](http://thrift.apache.org/):

> Thrift 是一个用于可扩展的跨语言服务开发的软件框架。它用一个代码生成引擎和软件技术栈来高效、无缝在C++, Java, Python, PHP, Ruby, Erlang, Perl, Haskell, C#, Cocoa, JavaScript, Node.js, Smalltalk, OCaml 之间构建服务

Thrift在有显而易见的丰富功能。缺乏的是一个良好的文档，本教程尝试填补这个漏洞。但是注意，这是一个参考指南，关于如何一步一步使用thrift，参阅Thrift教程。

## 语言参考

### Types：类型

Thrift的类型系统 由 预定义的基本类型、用户定义的结构、容器类型、异常和服务定义（RPC的接口）组成。

#### Base Types：基本类型

- bool: 一个布尔值（true 或者 false），一个字节
- byte: 一个有符号字节
- i16: 一个16 位有符号整形
- i32: 一个32 位有符号整形
- i64: 一个64 位有符号整形
- double: 一个 64 位浮点数
- binary:  一个字节数字
- string: 编码未知的文本或者二进制字符串

注意，Thrift不支持 无符号整型，因为在Thrift的很多目标语言中，无法直接翻译成本地（原始）类型。

#### Containers：容器

Thrift 容器 是强类型容器，映射到流行编程语言中最常用的容器。它们使用Java泛型风格来注释。提供了三种类型的容器：

- list<t1>: t1 类型元素的有序列表，可能包含重复
- set<t1>: 一组无序、不重复的t1类型元素
- map<t1,t2>: 类型t1作为严格唯一键 映射到 类型t2 作为值

容器中使用的类型可以是任何有效的Thrift 类型（包括 结构和异常），但不包括服务

#### Structs and Exceptions：结构和异常

Thrift 结构 在概念上与C的结构体类似——一种 将相关item关联（并且封装）到一起的便捷方式。结构 会转换成面向对象语言的类。

异常在语法和功能上与结构等效，只是异常被声明使用异常这种关键词而不是结构关键词。异常在语义上不同于结构——在定义RPC 服务的时候，开发者可能会声明远程方法抛出一个异常。

关于结构和异常的细节会在下文的部分。

#### Services：服务

服务的定义在语义上等同一个面向对象编程定义的接口（或一个纯虚拟抽象的类）。Thrift编译器生成实现结构的全部功能的client和server的存根。

有关定义服务的详细信息是后面部分的主题。

### Typedefs：类型定义

Thrift 支持C/C++ 风格的类型定义

```c
typedef i32 MyInteger   // 1
typedef Tweet ReTweet   // 2
```

| 1    | 注意这里没有末尾分号        |
| ---- | --------------------------- |
| 2    | 结构体也可以在typedef中使用 |

### Enums：枚举

当你正在定义一个message 类型时，你可能想要其中一个字段以只有一个预定义的值列表。

例如，假设你想要为每个Tweet 添加一个 tweetType 字段，其中tweetType 可以时TWEET、RETWEET、DM或REPLY。你可以通过在消息定义中添加一个枚举类型——具有枚举类型的字段可以只将一组指定常量之一作为值（如果你尝试提供不同的值，解析器将会将其按照未知字段来对待）。以下示例中，我们添加一个名为TweetType的枚举类型，其中包含所有可能的值和一个相同类型的字段：

```
enum TweetType {
    TWEET,       // 1
    RETWEET = 2, // 2
    DM = 0xa,    // 3
    REPLY
}                // 4

struct Tweet {
    1: required i32 userId;
    2: required string userName;
    3: required string text;
    4: optional Location loc;
    5: optional TweetType tweetType = TweetType.TWEET // 5
    16: optional string language = "english"
}
```

| 1    | 枚举是指定的C风格，编译器默认从0开始分配值 |
| ---- | ------------------------------------------ |
| 2    | 当然，你可以为常数提供指定的整型值         |
| 3    | 十六进制值也可以支持                       |
| 4    | 注意没有末尾分号                           |
| 5    | 分配默认值时使用常量的完全限定名           |

注意，与Protocol Buffers 不同，Thrift不支持嵌套枚举（或者结构）

枚举常量必须在32位正整数范围内。

### Comments ： 注释

Thrift支持shell风格、c风格的多行和单行的Java/C++风格注释

```java
# This is a valid comment.

/*
 * This is a multi-line comment.
 * Just like in C.
 */

// C++/Java style single-line comments work just as well.
```

### Namespaces：命名空间

Thrift中的命名空间类似C++的命名空间或Java中的包——它们提供了一种组织（或隔离）代码的便捷方式。命名空间还可以用于防止类型定义之间的命名冲突。

因为每种语言都有它自己的类似包的机制（例如Python由modules），Thrift允许您在每种语言的基础上自定义命名空间行为：

```thrift
namespace cpp com.example.project  // 1
namespace java com.example.project // 2
```

| 1    | 翻译成命名空间 com{ namespace example { namespace project { |
| ---- | ----------------------------------------------------------- |
| 2    | 翻译成package com.example.project                           |

### Includes：包括

这在单独文件里拆分Thrift的定义经常有用，以简化维护、实现重用和改进模块化/组织。Thrift允许文件包含其他Thrift文件。在当前文件查找包含的文件，并通过相对于 -l 编译器标志 指定的任何路径来搜索。

包含的对象被使用Thrift文件的名称作为前缀访问。

```
include "tweet.thrift"           // 1
...
struct TweetSearchResult {
    1: list<tweet.Tweet> tweets; // 2
}
```

| 1    | 文件名必须添加引号，再次注意缺少分号 |
| ---- | ------------------------------------ |
| 2    | 注意tweet的前缀                      |

### Constants：常数

Thrift允许你定义跨语言使用的常数。复杂类型和结构被使用JSON标记来指定。

```
const i32 INT_CONST = 1234;    // 1
const map<string,string> MAP_CONST = {"hello": "world", "goodnight": "moon"}
```

| 1    | 分号是可选的，十六进制数也有效 |
| ---- | ------------------------------ |

### Defining Structs：定义结构体

街头（在一些系统中也称为消息），是Thrift IDL中基本组成块。一个结构体由字段组成，每个字段都有一个唯一的整形标识符，一个类型，一个名字和一个可选的默认值。

```c
struct Location {                            // 5
    1: required double latitude;
    2: required double longitude;
}

struct Tweet {
    1: required i32 userId;                  // 1
    2: required string userName;             // 2
    3: required string text;
    4: optional Location loc;                // 3
    16: optional string language = "english" // 4
}
```

| 1    | 每个字段必须有一个唯一的正整数标识符         |
| ---- | -------------------------------------------- |
| 2    | 字段必须被标识为required或optional           |
| 3    | 结构体可能包含其他结构体                     |
| 4    | 你可以为字段指定默认值                       |
| 5    | 可以在同一个Thrift文件中定义和引用多个结构体 |

如你所见，在消息定义中的每个字段都有一个唯一的编号标签。这些标签用于以有线格式标识你的字段，一旦你的消息类型被使用就不应该被修改。

字段可以被标记为必须或可选，对于格式良好的结构具有明显的含义。例如，如果未在结构中设置必填字段，Thrift会报错。如果围在结构中设置可选字段，则不会通过网络对其序列化。如果为可选字段指定了默认值，则在解析结构时为该字段分配默认值，并且没有为该字段显示分配值。

与服务不同，结构体不支持继承，即一个结构体不能扩展其他结构体。

> 永远要求：
>
> 你应该非常仔细地根据需要标记字段。如果在某些时候，你希望停止写入或者发送必须字段，将字段更改为可选字段会出现文体——旧的readers将会认为没有此字段的消息不完整，并且可能无意地拒绝或丢弃它们。你应该考虑为你的缓冲区编写特定应用程序地自定义验证例程。有些人得出地结论是使用required 弊大于利；他们更喜欢只用可选的，然而这种观点并不普遍，

### Defining Services：定义服务

虽然有一些受欢迎的序列化/反序列（比如：Protocol Buffers），但很少有框架为跨多种语言的基于RPC的服务提供开箱即用的支持。这是Thrift的主要特性之一。

将服务定义视为Java接口——你需要为方法提供名字和签名。一个服务可以继承其他服务，这是可选的。

Thrift编译器将以你选择的语言生成服务结构代码（用于服务端）和存根stub（用于客户端）。Thrift 附带了大多数语言的RPC库，然后用来运行你的客户端和服务器。

```c
service Twitter {
    // A method definition looks like C code. It has a return type, arguments,
    // and optionally a list of exceptions that it may throw. Note that argument
    // lists and exception list are specified using the exact same syntax as
    // field lists in structs.
    void ping(),                                                             // 1
    bool postTweet(1:Tweet tweet) throws (1:TwitterUnavailable unavailable), // 2
    TweetSearchResult searchTweets(1:string query);                          // 3

    // The 'oneway' modifier indicates that the client only makes a request and
    // does not wait for any response at all. Oneway methods MUST be void.
    oneway void zip()                                                        // 4
}
```

| 1    | 迷惑的，方法定义可以使用逗号或者分号分隔 |
| ---- | ---------------------------------------- |
| 2    | 参数可以是原始类型或结构                 |
| 3    | 同样对于返回类型                         |
| 4    | void是函数的有效返回类型                 |

注意，函数的参数列表（和异常列表）的指定与结构完全相同。

服务支持继承：一个服务可以选择使用extends 关键词从另一个服务继承。

> 嵌套类型
>
> 在撰写文本时，Thrift不支持嵌套类型定义。也就是说，你不饿能在结构中定义结构（或枚举），你当然可以在其他结构中使用结构或枚举。

## Generated Code ： 生成代码

本节包含关于各种目标语言的Thrift生成代码的文档。我们开始介绍广泛使用的通用概念——这些概念控制生成的代码的的结构，并希望帮你理解如何高效使用它。

### Concepts：概念

Thrift网络栈的图示：

The Thrift Network Stack

```
+-------------------------------------------+
| cGRE                                      |
| Server                                    |
| (single-threaded, event-driven etc)       |
+-------------------------------------------+
| cBLU                                      |
| Processor                                 |
| (compiler generated)                      |
+-------------------------------------------+
| cGRE                                      |
| Protocol                                  |
| (JSON, compact etc)                       |
+-------------------------------------------+
| cGRE                                      |
| Transport                                 |
| (raw TCP, HTTP etc)                       |
+-------------------------------------------+
```

#### Transport：传输层

传输层为从/向 网络的 reading/writing 操作提供了一个简单的抽象。这使得Thrift 能够将底层传输与系统的剩余部分（例如序列化/反序列化）分离。

这是一些Transport接口暴露的方法：

- open
- close
- read
- write
- flush

除了上面的Transport 接口之外，Thrift还使用了Server Thrift接口，用来接受或建立基本的传输对象。顾名思义，ServerTransport住哟啊用于服务器端，来创建新的Transport对象为传入连接。

- open
- listen
- accept
- close

以下时大多数Thrift支持的语言可用的传输：

- file: read/write to/from a file on disk
- http: as the name suggests

#### Protocol：协议层

协议抽象定义了一种将内存中的数据结构映射到线性格式的机制。换句话说，协议执行数据类型如何使用底层传输层来 编码/解码自身。因此协议实现管理编码方案并负责（反）序列化。从这个一i以上，一些协议的例子包括，JSON、XML、纯文本，压缩二进制（compact binary）。

一些协议层接口

```
writeMessageBegin(name, type, seq)
writeMessageEnd()
writeStructBegin(name)
writeStructEnd()
writeFieldBegin(name, type, id)
writeFieldEnd()
writeFieldStop()
writeMapBegin(ktype, vtype, size)
writeMapEnd()
writeListBegin(etype, size)
writeListEnd()
writeSetBegin(etype, size)
writeSetEnd()
writeBool(bool)
writeByte(byte)
writeI16(i16)
writeI32(i32)
writeI64(i64)
writeDouble(double)
writeString(string)

name, type, seq = readMessageBegin()
                  readMessageEnd()
name = readStructBegin()
       readStructEnd()
name, type, id = readFieldBegin()
                 readFieldEnd()
k, v, size = readMapBegin()
             readMapEnd()
etype, size = readListBegin()
              readListEnd()
etype, size = readSetBegin()
              readSetEnd()
bool = readBool()
byte = readByte()
i16 = readI16()
i32 = readI32()
i64 = readI64()
double = readDouble()
string = readString()
```

Thrift协议在设计上面向流。不需要任何明确的框架。例如在我们开始序列化之前，没必要知道字符串的长度和列表中item的数量。

以下是大多数Thrift支持的语言的一些协议：

- binary: 相当简单的二进制编码 — 字段的长度和类型编码为字节，后跟字段的实际值。
- compact: 在这里有描述： [THRIFT-110](https://issues.apache.org/jira/browse/THRIFT-110) 
- json: 懂得都懂

#### Processor：处理器/或者进程

处理器封装了从输入流读取数据和写入输出流的能力，输入和输出流由协议对象表示，处理器接口非常简单：

```
interface TProcessor {
    bool process(TProtocol in, TProtocol out) throws TException
}
```

特定服务 的处理器 实现由编译器生成。处理器本质上从wire读取数据（使用输入协议），将处理代理给处理程序handler（由用户实现），同通过wire写出到响应（使用输出协议）

#### Server：服务端

服务端将上述功能汇集在一起：

- Create a transport：创建传输层
- Create input/output protocols for the transport：创建传输层的输入输出协议
- Create a processor based on the input/output protocols：创建基于输入输出协议的处理器
- Wait for incoming connections and hand them off to the processor：等待来到的连接和将它们交给处理器

接下来讨论为特定语言生成的代码，以下部分采用Thrift规范：

Example IDL

```c
namespace cpp thrift.example
namespace java thrift.example

enum TweetType {
    TWEET,
    RETWEET = 2,
    DM = 0xa,
    REPLY
}

struct Location {
    1: required double latitude;
    2: required double longitude;
}

struct Tweet {
    1: required i32 userId;
    2: required string userName;
    3: required string text;
    4: optional Location loc;
    5: optional TweetType tweetType = TweetType.TWEET;
    16: optional string language = "english";
}

typedef list<Tweet> TweetList

struct TweetSearchResult {
    1: TweetList tweets;
}

exception TwitterUnavailable {
    1: string message;
}

const i32 MAX_RESULTS = 100;

service Twitter {
    void ping(),
    bool postTweet(1:Tweet tweet) throws (1:TwitterUnavailable unavailable),
    TweetSearchResult searchTweets(1:string query);
    oneway void zip()
}
```

> 嵌套结构如何初始化
>
> 在前面的部分，我们看到Thrift如何允许结构体包含其他结构体（尽管还没有嵌套定义），在大多数面向对象和/或动态语言中，结构体映射到对象，因此了解Thrift如何初始化嵌套结构是有益的。一种合理的方法是将嵌套结构按照指针或引用对待，并使用null初始化它们，知道用户明确设置为止。
>
> 不幸的是，对于许多语言而言，Thrift使用value模型的方法。作为一个具体例子，考虑上面给Tweet结构生成的C++代码：
>
> ```
>   ...
>   int32_t userId;
>   std::string userName;
>   std::string text;
>   Location loc;
>   TweetType::type tweetType;
>   std::string language;
>   ...
> ```
>
> 如你所见，嵌套的Location结构是完全内联分配的。因为Location是可选的，代码使用了内部 _isset 标志来决定是否这个字段已经被用户设置。
>
> 这会导致一些令人惊讶和反常规的行为
>
> - 由于在一些语言中可能会在初始化时分配每个子结构的完全大小，因此内存使用量可能比你预期更高，特别是对很多未设置字段的复杂结构。
> - 服务方法的参数和返回类型可能不是可选的，并且你不能分配或返回null在任何动态语言中。因此要返回一个”no value“结果，你必须声明一个带有包含该值的可选字段的封装结构，然后返回这个未设置该字段的封装。
> - 但是，传输层可以控制来自旧版本服务定义且缺少参数的方法调用。因此如果原始服务包含一个方法postTweet（1：Tweet tweet）并且更高版本将其更改为postTweet（1：Tweet tweet，2：String group），则调用前一个方法的旧客户端将导致更新服务器接受未设置新参数的结果。例如如果新服务器使用Java，你实际上可能会收到新参数的空值。然而你不能在IDL中将参数生命为空。

### Java

#### Generated Files：生成文件

- 包含所有常量定义的单个文件（Constants.Java）
- 每个结构体、枚举和服务一个文件

```shell
$ tree gen-java
`-- thrift
    `-- example
        |-- Constants.java
        |-- Location.java
        |-- Tweet.java
        |-- TweetSearchResult.java
        |-- TweetType.java
        `-- Twitter.java
```

> 命名约定
>
> 虽然Thrift编译器不强制任何命名约定，但建议坚持标准命名约定，否则你可能会遇到一些意外。例如，如果你由一个名为tweetSearchResults（注意混合大小写），Thrift编译器将生成一个名为TweetSearchResults（注意CamelCase）的Java文件，其中包含一个名为tweetSearchResults的类（类似于原始结构）。这显然不会再Java下编译。

#### Types：类型

Thrift 将各种基本类型和容器类型映射到 Java 类型，如下所示：

- bool: boolean
- binary: byte[]
- byte: byte
- i16: short
- i32: int
- i64: long
- double: double
- string: String
- list<t1>: List<t1>
- set<t1>: Set<t1>
- map<t1,t2>: Map<t1, t2>

如你所见，映射在很大程度上是直接且一对一的。鉴于在 Thrift 项目开始时 Java 是主要的目标语言，这并不奇怪。

#### Typedefs：类型定义

Java语言对于”typedefs“没有任何本地化支持。所以当Thrift Java代码生成器遇到typedef声明时，它这是用原始类型来替换他。也就是说，即使你可能已经 typedef typeA 给 typeB，在生成的Java代码中，所有对typeB的引用都将被typeA替换。

#### Constants：常数

Thrift 将所有定义的常量放在名为 Constants 的公共类中作为 public static final 成员。 支持任何原始类型的常量。

> 包含你的常量
>
> 如果你有多少包含const 定义的Thrift文件（在同一个命名空间中），则Thrift编译器将用最后处理的文件中找到的定义来重写Constants文件。你必须在单个文件中定义所有常量，或者在包含所有其他文件的单个文件上调用编译器。

## Best Practices：最佳实践

### 版本控制/兼容性

协议随着时间而发展。如果一个现有的消息类型不再满足你的所有需求，例如，你希望消息格式有一个额外的字段，但你仍然希望使用以旧格式创建的代码，不要担心。在不破坏任何你现有代码的情况下，更新消息类型很简单，只需要记住以下原则：

- 以要改变任何现有字段的数字标签
- 你添加的任何新字段都应该时可选的。这意味着任何用旧消息格式的代码序列化的任何消息都可以由新生成的代码解析，因为它们不会丢失任何必须的元素。你应该为这些元素设置合理的默认值，以便新代码可以与旧代码正确交互。类似地，使用新代码创建地消息可以被旧代码解析：旧二进制文件在解析过程中简单地忽略新字段。但是，为止字段不会被丢弃，如果消息稍后被序列化，未知字段也会随之序列化，因此如果消息被传递给新代码。新字段仍然可用。
- 可以删除非必须字段，只要在你更新的消息类型中不再使用标签号（最好重命名该字段，也许添加前缀，以便您的.thrift未来用户不会不小心使用该号码）
- 修改默认值通常没问题，只要你记住默认值永远不会通过wire发送。因此，如果程序收到一个消息，其中没有设置特定字段，程序将看到默认值，因为它是在该程序的协议版本中定义的。它不会看到在发送方代码中定义的默认值。
