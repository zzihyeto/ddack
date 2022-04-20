// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#292b2c';

// Bar Chart Example
var ctx = document.getElementById("ddack1");
var myLineChart = new Chart(ctx, {
  type: 'bar',
  data: {
    labels: ["1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월","9월","10월", "11월", "12월"],
    datasets: [{
      label: "매출개수",
      backgroundColor: "rgba(2,117,216,1)",
      borderColor: "rgba(2,117,216,1)",
      data: [ 95, 85, 144, 139, 150, 127, 175, 152, 108, 81, 53, 32 ],
    }],
  },
  options: {
    scales: {
      xAxes: [{
        time: {
          unit: 'Month'
        },
        gridLines: {
          display: false
        },
        ticks: {
          maxTicksLimit: 6
        }
      }],
      yAxes: [{
        ticks: {
          min: 0,
          max: 200,
          maxTicksLimit: 5
        },
        gridLines: {
          display: true
        }
      }],
    },
    legend: {
      display: false
    }
  }
});
