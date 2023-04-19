import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.developer.registerproject.databinding.ItemUsersBinding
import com.developer.registerproject.db2.MyListobject
import com.developer.registerproject.model.Login
import com.developer.registerproject.model.Users

class MyRvAdapter (var list: List<Login>) : RecyclerView.Adapter<MyRvAdapter.VP_Vh>() {

    inner class VP_Vh(var itemUsersBinding: ItemUsersBinding  ):
        RecyclerView.ViewHolder(itemUsersBinding.root) {
        fun onBind(login: Login) {
            var myListobject=MyListobject()
            itemUsersBinding.name.text=login.login
            itemUsersBinding.number.text=login.parol
            myListobject.login=login.login
            myListobject.parol=login.parol




        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VP_Vh {
        return VP_Vh(ItemUsersBinding.inflate(LayoutInflater.from(parent.context),parent,false))


    }

    override fun onBindViewHolder(holder: VP_Vh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size





}