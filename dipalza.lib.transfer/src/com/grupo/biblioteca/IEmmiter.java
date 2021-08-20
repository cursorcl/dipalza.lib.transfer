package com.grupo.biblioteca;

import java.util.List;

public abstract interface IEmmiter
{
  public abstract boolean send(MessageToTransmit paramMessageToTransmit);

  public abstract boolean send(List<MessageToTransmit> paramVector);
}
