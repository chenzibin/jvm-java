package jvmparse.parse.entity.instruction;

import jvmparse.parse.ClassBuffer;
import lombok.Data;

/**
 * Aload
 *
 * @author chenzb
 * @date 2019/11/20
 */
@Data
public class Ldc extends Instruction {

    private int operand;

    public Ldc(ClassBuffer buffer, int opcode) {
        super(opcode);
        this.operand = buffer.u1();
    }
}
