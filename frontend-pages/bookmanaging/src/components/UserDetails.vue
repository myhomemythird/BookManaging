<template>
  <div>
    <h1>{{ title }} - {{ user.account }}</h1>
    <table id="user">
      <tr>
        <th>User ID</th><td>{{ user.id }}</td>
        <th>Account</th><td>{{ user.account }}</td>
      </tr>
      <tr>
        <th>Name</th><td colspan="5">{{ user.name }}</td>
      </tr>
      <tr>
        <th>Address</th><td colspan="5">{{ user.address }}</td>
      </tr>
      <tr>
        <th>Email</th><td colspan="5">{{ user.email }}</td>
      </tr>
      <tr>
        <th>Role</th><td colspan="5">{{ user.roleId }}</td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  name: 'UserDetails',
  data () {
    return {
      title: 'User Details',
      user: {id: '-', account: '-', roleId: '-'}
    }
  },
  mounted () {
    this.getUser();
  },
  methods: {
      getUser: function() {
          this.$ajax.get(this.GlobalConfig.userServiceUrl + '/user/' + this.$route.params.userid)
          .then(function(resp) {
              this.user = resp.data.obj;
          }.bind(this))
          .catch(error => {
              console.log('请求失败：'+error);
          });
      }
  }

}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
#user
  {
  font-family:"Trebuchet MS", Arial, Helvetica, sans-serif;
  width:100%;
  border-collapse:collapse;
  }

#user td, #user th
  {
  font-size:1em;
  border:1px solid #98bf21;
  padding:3px 7px 2px 7px;
  }

#user th
  {
    width: 10%;
  font-size:1.1em;
  padding-top:5px;
  padding-bottom:4px;
  background-color:#A7C942;
  color:#ffffff;
  }
</style>
