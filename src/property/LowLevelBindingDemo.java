package property;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class LowLevelBindingDemo {
	/**
	 * 
	 * 低级别绑定
	当对NumberBinding类进行子类化时，使用低级别绑定，例如Double类型的DoubleBinding类。
	
	在DoubleBinding类的子类中，我们覆盖它的computeValue()方法，以便可以使用运算符(例如*和 - )来制定复杂的数学方程计算。
	高级绑定使用如multiply()，subtract()等方法，而低级绑定使用诸如*和 - 等运算符。
	
	以下代码显示如何为公式创建低级别绑定，来计算矩形的面积。
	 */
	public static void main(String[] args) {
		DoubleProperty width = new SimpleDoubleProperty(2.0);
		DoubleProperty height = new SimpleDoubleProperty(4.0);
		DoubleBinding area = new DoubleBinding() {
			//使用初始化代码块,初始化匿名内部类
			{
				//super.bind(width, height);// initial bind
				this.bind(width, height);
			}

			@Override
			protected double computeValue() {
				// TODO Auto-generated method stub
				return width.get() * height.get();
			}

		};

		System.out.println(area.get());
	}
}
