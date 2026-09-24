package com.javanauta.usuario.infrastructure.exceptions;

import javax.naming.AuthenticationException;

public class UnauthorizedException extends AuthenticationException {

    public UnauthorizedException(String mensage) {super(mensage);}

    public UnauthorizedException(String mensage, Throwable throwable) {

        super (mensage);
    }
}
