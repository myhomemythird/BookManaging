<template>
  <div class="hello">
    <h1>{{ title }}</h1>
    <h2>Book List</h2>
    <table id="books">
      <tr>
        <th>Book ID</th>
        <th>Title</th>
        <th>Auth</th>
        <th>Description</th>
      </tr>
      <tr v-for="(row, i) in bookList" v-bind:class="{'alt': isEven(i)}">
        <td v-for="(col, j) in row">{{ col }}</td>
      </tr>
    </table>
    <button type="button" name="Get_Book_List" value="Get Book List" v-on:click="getBookList" >Book List</button>
  </div>
</template>

<script>
export default {
  name: 'BookManaging',
  data() {
    return {
      title: 'Book Managing System',
      bookList: [
          ['element 1', 'rat 1', 'cat 1', 'dog1'],
          ['element 2', 'rat 2', 'cat 2', 'dog2'],
          ['element 3', 'rat 3', 'cat 3', 'dog3']
      ]
    }
  },
  methods: {
      isEven: function(i) {
          return  (i % 2);
      },
      getBookList: function() {
          this.$ajax.get('http://localhost:8080/book-service/library/books')
          .then(function(resp) {
              debugger;
              console.log(resp);
          })
          .catch(error => {
              debugger;
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
  text-align:left;
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
