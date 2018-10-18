<template>
  <div>
    <h2>Searching Books</h2>
    Title: <input type="text" id="title" v-model="search.title" />
    Auth: <input type="text" id="auth" v-model="search.auth" />
    <button type="button" name="Search_Book_List" v-on:click="getBookList" >Go</button>
    <br />
    <br />
    <div v-if="hasBooks">
      <table id="books">
        <tr>
          <th>Book ID</th>
          <th>Title</th>
          <th>Auth</th>
        </tr>
        <tr v-for="(row, i) in bookList" v-bind:class="{'alt': isEven(i)}">
          <td>{{ row.id }}</td>
          <td><router-link :to="{name: 'BookDetails', params: {bookid: row.id}}" >{{ row.title }}</router-link></td>
          <td>{{ row.auth }}</td>
        </tr>
      </table>
    </div>
    <div v-else>
      <table id="books">
        <tr>
          <th>Book ID</th>
          <th>Title</th>
          <th>Auth</th>
        </tr>
        <tr>
          <td colspan="3" align="center">No Result Found</td>
        </tr>
      </table>
    </div>
    <br />
    <br />
    <div>
      <h2>Adding Books</h2>
      <table>
        <tr id="books">
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
      <button type="button" name="Add_Book" v-on:click="addBook" >Add</button>
    </div>
  </div>
</template>

<script>
export default {
  name: 'BookManaging',
  data () {
    return {
      search: {title: '', auth: ''},
      bookList: [],
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
      hasBooks: function() {
          return this.bookList.length > 0;
      },
      getBookList: function() {
          this.$ajax.get(this.GlobalConfig.bookServiceUrl + '/books', {
            params: {
              title: this.search.title,
              auth: this.search.auth
            }
          })
          .then(function(resp) {
              this.bookList = resp.data.obj;
          }.bind(this))
          .catch(error => {
              console.log('请求失败：'+error);
          });
      },
      addBook: function() {
        this.$ajax.post(this.GlobalConfig.bookServiceUrl + '/book', this.newBook)
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
#books
  {
  font-family:"Trebuchet MS", Arial, Helvetica, sans-serif;
  width:100%;
  border-collapse:collapse;
  }

#books td, #books th
  {
  font-size:1em;
  border:1px solid #98bf21;
  padding:3px 7px 2px 7px;
  }

#books th
  {
  font-size:1.1em;
  padding-top:5px;
  padding-bottom:4px;
  background-color:#A7C942;
  color:#ffffff;
  }

#books tr.alt td
  {
  color:#000000;
  background-color:#EAF2D3;
  }
</style>
