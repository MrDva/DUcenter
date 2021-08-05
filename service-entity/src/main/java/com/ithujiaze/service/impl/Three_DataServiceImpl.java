package com.ithujiaze.service.impl;

import com.itchenyang.result.R;
import com.ithujiaze.dao.Three_DataTableMapper;
import com.ithujiaze.entity.Three_Data;
import com.ithujiaze.service.Three_DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Three_DataServiceImpl implements Three_DataService {
    @Autowired
    private Three_DataTableMapper three_dataTableMapper;

    @Override
    public R GetThree_DataById(int id) {
        return R.ok().playCode(200).playMessage("成功").playData("three_data",three_dataTableMapper.GetThree_DataById(id));
    }

    @Override
    public R GetThree_DataByIdGroupByCount(int id) {
        return R.ok().playCode(200).playMessage("成功").playData("three_data",three_dataTableMapper.GetThree_DataByIdGroupByCount(id));
    }

    @Override
    public R insert(Three_Data three_data) {
        return R.ok().playCode(200).playMessage("成功").playData("three_data",three_dataTableMapper.insert(three_data));
    }

    @Override
    public R GetThree_DataByAddress(String address) {
        return R.ok().playCode(200).playMessage("成功").playData("three_data",three_dataTableMapper.GetThree_DataByAddress("%"+address+"%"));
    }

    @Override
    public R GetThree_DataByAddressNowDay(String address) {
        return R.ok().playCode(200).playMessage("成功").playData("three_data",three_dataTableMapper.GetThree_DataByAddressNowDay("%"+address+"%"));
    }

    @Override
    public R GetThree_DataByAddressSevenDay(String address) {
        return R.ok().playCode(200).playMessage("成功").playData("three_data",three_dataTableMapper.GetThree_DataByAddressSevenDay("%"+address+"%"));
    }

    @Override
    public R GetThree_DataByAddressOneMonth(String address) {
        return R.ok().playCode(200).playMessage("成功").playData("three_data",three_dataTableMapper.GetThree_DataByAddressOneMonth("%"+address+"%"));
    }

    @Override
    public R DeleteThree_DataByThreeMonth() {
        return R.ok().playCode(200).playMessage("成功").playData("three_data",three_dataTableMapper.DeleteThree_DataByThreeMonth());
    }
}
