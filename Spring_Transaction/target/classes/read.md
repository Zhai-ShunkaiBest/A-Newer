propagation  事务的传播行为(面试)
多事务方法之间调用,事务是如何管理的

事务传播行为类型

说明

PROPAGATION_REQUIRED

如果当前没有事务，就新建一个事务，如果已经存在一个事务中，加入到这个事务中。这是最常见的选择(默认)。

PROPAGATION_SUPPORTS

支持当前事务，如果当前没有事务，就以非事务方式执行。

PROPAGATION_MANDATORY

使用当前的事务，如果当前没有事务，就抛出异常。

PROPAGATION_REQUIRES_NEW

新建事务，如果当前存在事务，把当前事务挂起。

PROPAGATION_NOT_SUPPORTED

以非事务方式执行操作，如果当前存在事务，就把当前事务挂起。

PROPAGATION_NEVER

以非事务方式执行，如果当前存在事务，则抛出异常。

PROPAGATION_NESTED

如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，则执行与PROPAGATION_REQUIRED类似的操作。


如果service层  add方法调用了 addDept和addEmp两个方法

PROPAGATION_REQUIRED
如果add方法有事务,那么addDept和addEmp就加入到add方法里的事务
如果add方法没有事务,那么就新建一个事务,将addDept和addEmp加入到这个新的事务中

PROPAGATION_REQUIRES_NEW
无论add是否有事务,都建立一个新的事务,所有的方法都加入到新的事务中,add原来的事务就不用了


isolation 事务的隔离级别

1) DEFAULT （默认）
   这是一个PlatfromTransactionManager默认的隔离级别，使用数据库默认的事务隔离级别。另外四个与JDBC的隔离级别相对应。
   MySQL默认REPEATABLE_READ   
   Oracle默认READ_COMMITTED

2) READ_UNCOMMITTED （读未提交）
   这是事务最低的隔离级别，它允许另外一个事务可以看到这个事务未提交的数据。这种隔离级别会产生脏读，不可重复读和幻像读。

3) READ_COMMITTED （读已提交）
   保证一个事务修改的数据提交后才能被另外一个事务读取，另外一个事务不能读取该事务未提交的数据。这种事务隔离级别可以避免脏读出现，但是可能会出现不可重复读和幻像读。

4) REPEATABLE_READ （可重复读）
   这种事务隔离级别可以防止脏读、不可重复读，但是可能出现幻像读。它除了保证一个事务不能读取另一个事务未提交的数据外，还保证了不可重复读。

5) SERIALIZABLE（串行化）
   这是花费最高代价但是最可靠的事务隔离级别，事务被处理为顺序执行。除了防止脏读、不可重复读外，还避免了幻像读。

timeout 超时时间
事务一定要在多长时间之内提交,如果不提交就会回滚

readOnly 只读事务
事务是否只能读取数据库的数据,如果为true,则不允许进行增删改

rollbackFor 指定发生回滚的异常
当方法发生哪些异常时才会回滚

noRollbackFor 指定不发生回滚的异常
当方法发生哪些异常时,不会回滚
