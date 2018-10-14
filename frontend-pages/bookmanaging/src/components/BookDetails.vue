<template>
  <div>
    <h1>{{ title }} - {{ book.title }}</h1>
    <table id="book">
      <tr>
        <th>Book ID</th><td>{{ book.id }}</td>
        <th>Auth</th><td>{{ book.auth }}</td>
        <th>Publish Date</th><td>{{ book.publishDate }}</td>
      </tr>
      <tr>
        <th>Title</th><td colspan="5">{{ book.title }}</td>
      </tr>
      <tr>
        <th>Description</th><td colspan="5">{{ book.description }}</td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  name: 'BookDetails',
  data () {
    return {
      title: 'Book Details',
      book: {id: '-',title: '-', auth: '-', description: '-', publishDate: '-'}
    }
  },
  mounted () {
    this.getBook();
  },
  methods: {
      getBook: function() {
          this.$ajax.get(this.GlobalConfig.bookServiceUrl + '/book/' + this.$route.params.bookid)
          .then(function(resp) {
              this.book = resp.data.obj;
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
#book
  {
  font-family:"Trebuchet MS", Arial, Helvetica, sans-serif;
  width:100%;
  border-collapse:collapse;
  }

#book td, #book th
  {
  font-size:1em;
  border:1px solid #98bf21;
  padding:3px 7px 2px 7px;
  }

#book th
  {
    width: 10%;
  font-size:1.1em;
  padding-top:5px;
  padding-bottom:4px;
  background-color:#A7C942;
  color:#ffffff;
  }
</style>
