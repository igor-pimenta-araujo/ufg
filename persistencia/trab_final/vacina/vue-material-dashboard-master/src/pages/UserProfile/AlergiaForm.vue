<template>
  <form>
    <md-card>
      <md-card-header :data-background-color="dataBackgroundColor">
        <h4 class="title">Cadastrar Alergia</h4>
      </md-card-header>

      <md-card-content>
        <div class="md-layout">
          <div class="md-layout-item md-small-size-100 md-size-50">
            <md-field>
              <label>Nome</label>
              <md-input v-model="nome" type="string"></md-input>
            </md-field>
          </div>
          <div class="md-layout-item md-size-100 text-right">
            <md-button @click="cadastrarAlergia()" class="md-raised md-success">
              Cadastrar
            </md-button>
          </div>
        </div>
      </md-card-content>
    </md-card>
  </form>
</template>
<script>
export default {
  name: "edit-profile-form",
  props: {
    dataBackgroundColor: {
      type: String,
      default: "",
    },
  },
  data() {
    return {
      nome: "",
    };
  },
  methods: {
    async cadastrarAlergia() {
      const response = await this.$axios.post(
        `http://localhost:8080/alergia`,
        {
          nome: this.nome,
        },
        {
          headers: {
            "Content-Type": "application/json",
          },
        }
      );
      this.$router.push("/visualizar-alergia");
    },
  },
};
</script>
