package self.jvm.parse.parse.entity;

import self.jvm.parse.parse.ClassBuffer;
import self.jvm.parse.parse.factory.ConstantFactory;
import self.jvm.parse.parse.entity.constant.Constant;
import lombok.Data;

/**
 * Created by chenzibin on 2019/11/2.
 */
@Data
public class ConstantPool {

    private Constant[] constants;

    public ConstantPool(ClassBuffer buffer, int constantPoolCount) {
        this.constants = new Constant[constantPoolCount];
        ConstantFactory constantFactory = new ConstantFactory();
        for (int i = 1; i < constantPoolCount; i++) {
            Constant constant = constantFactory.getConstant(buffer);
            constants[i] = constant;
            if (constant.getTag() == ConstantFactory.CONSTANT_DOUBLE ||
                    constant.getTag() == ConstantFactory.CONSTANT_LONG) {
                i++;
            }
        }
    }
}
