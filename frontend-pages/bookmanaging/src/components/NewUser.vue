  <template>
  <div>
    <h2>Adding Users</h2>
    <br />
    <br />
    <div>
      <table id="users">
        <tr>
          <th>Account</th>
          <td><input type="text" id="account" v-model="newUser.account" /></td>
          <th>Name</th>
          <td>
            <input type="text" id="name" v-model="newUser.name" @blur.prevent="validator().name()"/><br />
            <label id="error" v-if="!validation.name">Name cannot be empty</label>
          </td>
        </tr>
        <tr>
          <th>Password</th>
          <td><input type="password" id="password" v-model="newUser.password" /></td>
        </tr>
        <tr>
          <th>Confirmed Password</th>
          <td><input type="password" id="confirmedPassword" v-model="newUser.confirmedPassword" /></td>
        </tr>
        <tr>
          <th>Address</th>
          <td><input type="text" id="address" v-model="newUser.address" /></td>
        </tr>
        <tr>
          <th>Email</th>
          <td>
            <input type="text" id="email" v-model="newUser.email" @blur.prevent="validator().email()" /><br />
            <label id="error" v-if="!validation.email">Please enter a valid Email</label>
          </td>
        </tr>
        <tr>
          <th>Role</th>
          <td><input type="text" id="roleId" v-model="newUser.roleId" /></td>
        </tr>
      </table>
      <div v-if="isCallSucessful | isCallingError">
        <label>{{ addingMessage }}</label><br />
      </div>
      <br />
      <br />
      <div align="center"><button type="button" name="Add_User" v-on:click="addUser">Add</button></div>
    </div>
  </div>
</template>

<script>
  var emailRE = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
export default {
  name: 'UserAdding',
  data () {
    return {
      newUser: {name: '', email: ''},
      isCallSucessful: false,
      isCallingError: false,
      addingMessage: 'Test',
      validation: {name: true, email: true}
    }
  },
  methods: {
      addUser: function() {
        this.$ajax.post(this.GlobalConfig.userServiceUrl + '/user', this.newUser)
        .then(function(resp) {
          console.log(resp.data);
          this.isCallSucessful = true;
          this.isCallingError = false;
          if (resp.data.retCode == 0) {
            this.addingMessage = 'Adding User Successful!';
            this.newUser = {};
            this.getBookList();
          } else {
            this.addingMessage = resp.data.obj;
          }
        }.bind(this))
        .catch(function(error) {
          console.log('请求失败：'+error);
          this.isCallSucessful = false;
          this.isCallingError = true;
          this.addingMessage = 'Adding User Fail! ' + error;
        }.bind(this));
      },
      isValid: function() {
        var validation = this.validation;
        return Object.keys(validation).every(function(key) {
          return validation[key];
        });
      },
      validator: function() {
        var that = this;
        return {
          name: function() {
            that.validation.name = (!!that.newUser.name.trim());
          },
          email: function() {
            that.validation.email = (!that.newUser.email.trim() || emailRE.test(that.newUser.email));
          }
        }
      }
  }

}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
#users
  {
  font-family:"Trebuchet MS", Arial, Helvetica, sans-serif;
  width:100%;
  border-collapse:collapse;
  }

#users td, #users th
  {
  font-size:1em;
  padding:3px 7px 2px 7px;
  }

#users th
  {
    width: 15%;
  font-size:1.1em;
  padding-top:5px;
  padding-bottom:4px;
  background-color:#A7C942;
  color:#ffffff;
  text-align: right;
  }

#users tr.alt td
  {
  color:#000000;
  background-color:#EAF2D3;
  }
  input {
    width: 90%;
  }
#error {
  color: red;
}
</style>
