  <template>
  <div>
    <h2>Searching Users</h2>
    Role ID: <input type="text" id="roleId" v-model="search.roleId" />
    Account: <input type="text" id="account" v-model="search.account" />
    <button type="button" name="Search_User_List" v-on:click="getUserList" >Go</button>
    <br />
    <br />
    <div v-if="hasUsers">
      <table id="users">
        <tr>
          <th>User ID</th>
          <th>Account</th>
          <th>Role</th>
        </tr>
        <tr v-for="(row, i) in userList" v-bind:class="{'alt': isEven(i)}">
          <td>{{ row.id }}</td>
          <td>{{ row.account }}</td>
          <td>{{ row.roleId }}</td>
        </tr>
      </table>
    </div>
    <div v-else>
      <table id="users">
        <tr>
          <th>User ID</th>
          <th>Account</th>
          <th>Role</th>
        </tr>
        <tr>
          <td colspan="3" align="center">No Result Found</td>
        </tr>
      </table>
    </div>
    <br />
    <br />
    <div>
      <h2>Adding Users</h2>
      <table>
        <tr id="users">
          <th>Book ID</th>
          <th>Title</th>
          <th>Auth</th>
          <th>Description</th>
          <th>Publish Date</th>
        </tr>
        <tr>
          <td><input type="text" id="id" v-model="newBook.id" /></td>
          <td><input type="text" id="title" v-model="newBook.title" /></td>
          <td><input type="text" id="auth" v-model="newBook.auth" /></td>
          <td><input type="text" id="description" v-model="newBook.description" /></td>
          <td><input type="text" id="publishDate" v-model="newBook.publishDate" /></td>
        </tr>
      </table>
      <div v-if="isCallSucessful | isCallingError">
        <label>{{ addingMessage }}</label><br />
      </div>
      <button type="button" name="Add_Book" v-on:click="addBook" disabled="true">Add</button>
    </div>
  </div>
</template>

<script>
export default {
  name: 'UserManaging',
  data () {
    return {
      search: {roleId: '', account: ''},
      userList: [],
      newBook: {},
      isCallSucessful: false,
      isCallingError: false,
      addingMessage: 'Test'
    }
  },
  mounted () {
    this.getBookList();
  },
  methods: {
      isEven: function(i) {
          return (i % 2);
      },
      hasUsers: function() {
          return this.userList.length > 0;
      },
      getUserList: function() {
          this.$ajax.get(this.GlobalConfig.userServiceUrl + '/users', {
            params: {
              roleId: this.search.roleId,
              account: this.search.account
            }
          })
          .then(function(resp) {
              this.userList = resp.data.obj;
          }.bind(this))
          .catch(error => {
              console.log('请求失败：'+error);
          });
      },
      addBook: function() {
        this.$ajax.post(this.GlobalConfig.userServiceUrl + '/book', this.newBook)
        .then(function(resp) {
          console.log(resp.data);
          this.isCallSucessful = true;
          this.isCallingError = false;
          if (resp.data.retCode == 0) {
            this.addingMessage = 'Adding Book Successful!';
            this.newBook = {};
            this.getBookList();
          } else {
            this.addingMessage = resp.data.obj;
          }
        }.bind(this))
        .catch(function(error) {
          console.log('请求失败：'+error);
          this.isCallSucessful = false;
          this.isCallingError = true;
          this.addingMessage = 'Adding Book Fail!' + error;
        }.bind(this));
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
  border:1px solid #98bf21;
  padding:3px 7px 2px 7px;
  }

#users th
  {
  font-size:1.1em;
  padding-top:5px;
  padding-bottom:4px;
  background-color:#A7C942;
  color:#ffffff;
  }

#users tr.alt td
  {
  color:#000000;
  background-color:#EAF2D3;
  }
</style>
