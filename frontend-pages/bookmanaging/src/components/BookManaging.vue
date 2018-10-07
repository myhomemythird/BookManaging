<template>
  <div>
    <h1>{{ title }}</h1>
    <h2>Book List</h2>
    Title: <input type="text" id="title" v-model="search.title" />
    Auth: <input type="text" id="auth" v-model="search.auth" />
    <button type="button" name="Search_Book_List" v-on:click="getBookList" >Go</button>
    <div v-if="hasBooks">
      <table id="books">
        <tr>
          <th>Book ID</th>
          <th>Title</th>
          <th>Auth</th>
          <th>Description</th>
        </tr>
        <tr v-for="(row, i) in bookList" v-bind:class="{'alt': isEven(i)}">
          <td>{{ row.id }}</td>
          <td>{{ row.title }}</td>
          <td>{{ row.auth }}</td>
          <td>{{ row.description }}</td>
        </tr>
      </table>
    </div>
    <div v-else>
      <table id="books">
        <tr>
          <th>Book ID</th>
          <th>Title</th>
          <th>Auth</th>
          <th>Description</th>
        </tr>
        <tr>
          <td colspan="4" align="center">No Result Found</td>
        </tr>
      </table>
    </div>
  </div>
</template>

<script>
export default {
  name: 'BookManaging',
  data () {
    return {
      title: 'Book Managing System',
      search: {title: '', auth: ''},
      bookList: []
    }
  },
  methods: {
      isEven: function(i) {
          return (i % 2);
      },
      hasBooks: function() {
          return this.bookList.length > 0;
      },
      getBookList: function() {
          this.$ajax.get('http://localhost:8080/book-service/library/books', {
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
