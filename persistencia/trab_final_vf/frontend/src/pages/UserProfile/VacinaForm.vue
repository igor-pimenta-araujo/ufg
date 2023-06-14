<template>
  <form>
    <md-card>
      <md-card-header :data-background-color="dataBackgroundColor">
        <h4 class="title">Cadastrar Vacina</h4>
      </md-card-header>

      <md-card-content>
        <div class="md-layout">
          <div class="md-layout-item md-small-size-100 md-size-50">
            <md-field>
              <label>Titulo</label>
              <md-input v-model="titulo"></md-input>
            </md-field>
            <md-field>
              <label>Descrição</label>
              <md-input v-model="descricao"></md-input>
            </md-field>
            <md-field>
              <label>Doses</label>
              <md-input v-model="doses"></md-input>
            </md-field>
            <md-field>
              <label>periodicidade</label>
              <md-select v-model="periodicidade">
                <md-option
                  v-for="item in periodicidadeDisponivel"
                  :key="item"
                  :value="item"
                >
                  {{ item }}
                </md-option>
              </md-select>
            </md-field>
            <md-field>
              <label>Intervalo</label>
              <md-input v-model="intervalo"></md-input>
            </md-field>
          </div>
          <div class="md-layout-item md-size-100 text-right">
            <md-button @click="cadastrarVacina()" class="md-raised md-success">
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
      titulo: "",
      descricao: "",
      doses: "",
      periodicidade: "",
      intervalo: "",
      periodicidadeDisponivel: ["dias", "semanas", "meses", "anos"],
    };
  },
  methods: {
    async cadastrarVacina() {
      const response = await this.$axios.post(
        `http://localhost:8080/vacina`,
        {
          titulo: this.titulo,
          descricao: this.descricao,
          doses: this.doses,
          periodicidade: this.periodicidade,
          intervalo: this.intervalo,
        },
        {
          headers: {
            "Content-Type": "application/json",
          },
        }
      );
      this.$router.push("/visualizar-vacinas");
    },
  },
};
</script>
