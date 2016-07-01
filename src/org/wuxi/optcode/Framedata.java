package org.wuxi.optcode;

import java.nio.ByteBuffer;
import java.nio.ByteBuffer;

//Referenced classes of package org.wuxi.optcode:
//         CLASS419

public interface Framedata
{

 public abstract ByteBuffer getPayloadData();

 public abstract boolean isFin();

 public abstract boolean getTransfereMasked();

 public abstract CLASS419 getOpcode();
}
