package PresentationLayer;

import DBAccess.UserMapper;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangePassword extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        String password = request.getParameter("password");
        String email = request.getParameter("email");
        UserMapper.changePassword(password,email);
        return "employeepage";
    }
}
