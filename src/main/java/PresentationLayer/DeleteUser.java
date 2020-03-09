package PresentationLayer;

import DBAccess.UserMapper;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteUser extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        String email = request.getParameter("email");
        UserMapper.deleteUser(email);
        return "employeepage";
    }
}
