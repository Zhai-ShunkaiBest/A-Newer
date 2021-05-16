package top.cliffside.service;

/**
 * @author cliffside
 * @date 2021-05-16 15:08
 * 紧耦合方式(了解)
 * DispatcherServlet中的service方法直接将此次请求的request对象传递给调用的单元方法即可。
 * 同时在单元方法上声明形参HttpServletRequest来接收request实参即可。
 * 解耦合方式(熟练)
 * DispatcherServlet在其service方法中将请求数据根据需求从request对象中获取出来后，
 * 将数据直接传递给对应的单元方法使用。同时在单元方法上直接声明对应的形参接收请求数据即可。
 * 在单元方法上声明形参来接收请求数据时，形参名必须和请求数据的键名一致，
 * DispatcherServlet会将调用单元方法的形参名作为请求数据的键名获取请求数据，
 * 然后传递给单元方法。
 */
public class TestDataController {
}
