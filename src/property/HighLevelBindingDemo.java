package property;

import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * 
 * @author yangzaozao
 *
 *
 *高级别的属性绑定
 */
public class HighLevelBindingDemo {

	/**
	 * 
	 * 高级别绑定
	我们也可以使用JavaFX流利的API来绑定属性。API使用类似英语的方法名称对属性执行操作。 
	例如，multiply()，divide()，subtract()，isEqualTo()，isNotEqualTo()，concat()。
	 请注意，方法名称中没有get或set。当链接API在一起时可以写代码，就像类似于写英文句子，
	 例如，width().multiply(height()).divide(2)。
	
	以下代码显示如何创建表示计算矩形面积的公式的属性。
	
	它通过使用javafx.beans.binding.IntegerExpression接口中的fluent API来执行高级绑定。
	
	该代码使用multiply()方法，该方法返回包含计算值 - NumberBinding。
	
	这个绑定是延迟评估求值的，这意味着乘法不会执行计算，除非通过get()或getValue()方法调用属性的值。
	 */
	public static void main(String[] args) {

		//Area = width * height;
		IntegerProperty width = new SimpleIntegerProperty(10);
		IntegerProperty height = new SimpleIntegerProperty(20);
		NumberBinding area = width.multiply(height);
		System.out.println(area.getValue());
	}
}
