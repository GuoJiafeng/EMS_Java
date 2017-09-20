package gjf.com.ems_java.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import gjf.com.ems_java.R;
import gjf.com.ems_java.entity.Emp;

/**
 * Created by BlackBeard丶 on 2017/9/18.
 */

public class ShowAllEmpViewAdapter extends RecyclerView.Adapter<ShowAllEmpViewAdapter.ViewHolder> {

    private List<Emp> empList;
    private LayoutInflater inflater;

    public ShowAllEmpViewAdapter(Context context,List<Emp> empList) {
        inflater =  LayoutInflater.from(context);
        this.empList = empList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = inflater.inflate(R.layout.showallemp_item, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
    Emp emp = empList.get(position);
    holder.emp_id .setText(emp.getId());
    holder.emp_name .setText(emp.getName());
    holder.emp_salary .setText(emp.getSalary());
    holder.emp_married .setText(emp.getMarried());
    holder.emp_hiredate .setText(emp.getHireDate());
    holder.emp_deptname .setText(emp.getDeptName());

    }

    @Override
    public int getItemCount() {
        return empList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView emp_id;
        TextView emp_name;
        TextView emp_salary;
        TextView emp_married;
        TextView emp_hiredate;
        TextView emp_deptname;

        public ViewHolder(View itemView) {
            super(itemView);
            emp_id = (TextView) itemView.findViewById(R.id.emp_id);
            emp_name = (TextView) itemView.findViewById(R.id.emp_name);
            emp_salary = (TextView) itemView.findViewById(R.id.emp_salary);
            emp_married = (TextView) itemView.findViewById(R.id.emp_married);
            emp_hiredate = (TextView) itemView.findViewById(R.id.emp_hireDate);
            emp_deptname = (TextView) itemView.findViewById(R.id.emp_deptName);
        }
    }
}
