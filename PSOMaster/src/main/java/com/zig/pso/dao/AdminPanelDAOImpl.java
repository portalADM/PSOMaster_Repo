/************************************************************************************************************
 * Class Name : AdminPanelDAOImpl.java Description:
 * 
 * Author : Ankita Mishra Date : Apr 12, 2017 **********************************************************************************************************
 */
package com.zig.pso.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.zig.pso.constants.PSOConstants;
import com.zig.pso.logging.PSOLoggerSrv;
import com.zig.pso.rest.bean.BaseResponseBean;
import com.zig.pso.rest.bean.RemediationStepRequest;
import com.zig.pso.utility.CommonUtility;
import com.zig.pso.utility.DBConnection;
import com.zig.pso.utility.OrderQueries;

/**
 * 
 */
@Repository
public class AdminPanelDAOImpl implements AdminPanelDAO
{

    private Connection portalDBConnection = null;

    public AdminPanelDAOImpl()
    {
        portalDBConnection = DBConnection.getPortalDBConnection();
    }

    @Override
    public BaseResponseBean addRemediationSteps(RemediationStepRequest remediationRequest)
    {
        BaseResponseBean remediationStepRes = new BaseResponseBean();
        String logRefID = CommonUtility.getLogRefID();
        String sql = null;
        if ("ADD".equals(remediationRequest.getType()))

            sql = OrderQueries.getInsertRemediationStep();

        else if ("UPDATE".equals(remediationRequest.getType()))

            sql = OrderQueries.updateOrderSim();

        else if ("DELETE".equals(remediationRequest.getType()))

            sql = OrderQueries.updateOrderSim();

        try
        {

            PreparedStatement pstm = portalDBConnection.prepareStatement(sql);
            int stepSize = remediationRequest.getRemediationSteps().size();
            for (int k = 0; k <= stepSize - 1; k++)
            {
                pstm.setString(1, remediationRequest.getOrderStatus());
                pstm.setString(2, remediationRequest.getRemediationSteps().get(k));
                pstm.addBatch();
            }
            int[] i = pstm.executeBatch();
            System.out.println(i[0]);

            remediationStepRes.setErrorCode(PSOConstants.SUCCESS_CODE);
            remediationStepRes.setErrorMsg(PSOConstants.ORDER_UPDATE_SUCCESSFULL);
            remediationStepRes.setLogRefId(logRefID);
            PSOLoggerSrv.printSQL_DEBUG("AdminPanelDAOImpl", "addRemediationStep", logRefID, sql, remediationRequest, remediationStepRes.getErrorMsg());

        }
        catch (SQLException e)
        {
            remediationStepRes.setErrorCode(PSOConstants.ERROR_CODE);
            remediationStepRes.setErrorMsg(PSOConstants.BACKEND_ERROR);
            remediationStepRes.setLogRefId(logRefID);
            System.out.println(e);
            e.printStackTrace();
            PSOLoggerSrv.printERROR("AdminPanelDAOImpl", "addRemediationSteps", logRefID, sql, remediationRequest, e);
        }

        return remediationStepRes;

    }
}
