<template>
  <div class="content">
    <div class="md-layout">
      <div
        class="md-layout-item md-medium-size-100 md-xsmall-size-100 md-size-100"
      >
        <md-card>
          <md-card-header data-background-color="green">
            <h4 class="title">{{ path }}</h4>
          </md-card-header>
          <md-card-content>
            <agendamentos-table :items="this.item"></agendamentos-table>
          </md-card-content>
        </md-card>
      </div>
    </div>
  </div>
</template>

<script>
import AgendamentosTable from "../components/Tables/AgendamentosTable.vue";
export default {
  components: { AgendamentosTable },
  data: () => ({
    item: {},
    path: "",
  }),
  created() {
    this.getUsuario();
    this.path = this.$route.name;
  },
  methods: {
    async getUsuario() {
      const response = await this.$axios.get(
        `http://localhost:8080` + this.$route.path,
        {
          headers: {},
        }
      );
      this.item = response.data;
      console.log(this.item);
    },
  },
};
</script>
